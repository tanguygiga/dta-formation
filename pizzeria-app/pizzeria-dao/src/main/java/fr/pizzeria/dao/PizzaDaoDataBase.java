package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoDataBase implements IDao<Pizza> {

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

	@Override
	public List<Pizza> findAll() throws StockageException {

		String sql = "SELECT * FROM pizza";

		try (Connection connexion = DriverManager.getConnection(dbURL, user, password);
				Statement statement = connexion.createStatement();
				ResultSet result = statement.executeQuery(sql);) {

			while (result.next()) {
				int id = result.getInt(1);
				String libelle = result.getString(2);
				String reference = result.getString(3);
				double prix = result.getDouble(4);
				String url_image = result.getString(5);

				System.out.println(
						id + ". " + reference + " - " + libelle + " (" + prix + " €)" + " [" + url_image + "]");

			}
		} catch (SQLException e) {
			throw new StockageException(e);
		}
		return null;
	}

	@Override
	public void save(Pizza t) throws StockageException {

		try (Connection connexion = DriverManager.getConnection(dbURL, user, password)) {

			String sql = "INSERT INTO pizza (libelle, reference, prix, url_image) VALUES (?, ?, ?, ?)";

			PreparedStatement statement = connexion.prepareStatement(sql);
			String libelle = t.getNom();
			String reference = t.getCode();
			double prix = t.getPrix();
			String url_image = null;

			statement.setString(1, libelle);
			statement.setString(2, reference);
			statement.setDouble(3, prix);
			statement.setString(4, url_image);
			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
		} catch (SQLException e) {
			throw new StockageException(e);
		}

	}

	@Override
	public void update(String codePizza, Pizza t) throws StockageException {

	}

	@Override
	public void delete(String codePizza) throws StockageException {

	}

}
