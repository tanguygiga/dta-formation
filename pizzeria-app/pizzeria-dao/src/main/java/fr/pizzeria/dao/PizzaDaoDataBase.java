package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoDataBase implements IDao<Pizza, String> {

	private String driver;
	private String dbURL;
	private String user;
	private String password;

	public PizzaDaoDataBase() {
		// récupération des informations de connexion depuis le fichier
		// jdbc.properties
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

		driver = bundle.getString("database.driver");
		dbURL = "jdbc:" + bundle.getString("database.type") + "://" + bundle.getString("database.host") + ":"
				+ bundle.getString("database.port") + "/" + bundle.getString("database.name");
		user = bundle.getString("database.user");
		password = bundle.getString("database.password");
	}

	private Connection createNewConnexion() throws SQLException {
		Connection connexion = DriverManager.getConnection(dbURL, user, password);
		return connexion;

	}

	@Override
	public List<Pizza> read() throws StockageException {

		List<Pizza> pizzas = new ArrayList<>();

		String sql = "SELECT * FROM pizza";

		try (Connection connexion = createNewConnexion();
				Statement st = connexion.createStatement();
				ResultSet result = st.executeQuery(sql);) {

			while (result.next()) {
				// int id = result.getInt(1);
				String libelle = result.getString(2);
				String reference = result.getString(3);
				double prix = result.getDouble(4);
				// String url_image = result.getString(5);

				pizzas.add(new Pizza(reference, libelle, prix, null));
			}
			Collections.sort(pizzas);
		} catch (SQLException e) {
			throw new StockageException(e);
		}
		return pizzas;
	}

	@FunctionalInterface
	public interface Exec {
		public void execute(PreparedStatement ps) throws SQLException;
	}

	public void executeUpdate(String sql, Exec ex) throws StockageException {
		try (Connection connexion = createNewConnexion(); PreparedStatement st = connexion.prepareStatement(sql);) {

			ex.execute(st);

		} catch (SQLException e) {
			throw new StockageException(e);
		}
	}

	@Override
	public void create(Pizza t) throws StockageException {
		executeUpdate("INSERT INTO pizza (libelle, reference, prix, url_image) VALUES (?, ?, ?, ?)", st -> {
			st.setString(1, t.getNom());
			st.setString(2, t.getCode());
			st.setDouble(3, t.getPrix());
			st.setString(4, "");
		});

	}

	@Override
	public void update(String codePizza, Pizza t) throws StockageException {

	}

	@Override
	public void delete(String codePizza) throws StockageException {

	}

	@Override
	public void importData(IDao<Pizza, String> source) throws DaoException {
		// List<List<Pizza>> listOfList = ListUtils.partition(source.findAll(),
		// 3);
	}

}
