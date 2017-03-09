package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoDataBase implements IDao<Pizza> {

	private Connection conn = null;
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
		/*
		 * try { Class.forName(driver); } catch (ClassNotFoundException e1) {
		 * e1.printStackTrace(); }
		 */
		try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {

			String sql = "SELECT * FROM pizza";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			// int count = 0;

			while (result.next()) {
				int id = result.getInt(1);
				String libelle = result.getString(2);
				String reference = result.getString(3);
				double prix = result.getDouble(4);
				String url_image = result.getString(5);

				System.out.println(
						id + ". " + reference + " - " + libelle + " (" + prix + " €)" + " [" + url_image + "]");
				/*
				 * String output = "#%d: %s - %s - %s - %s - %s";
				 * System.out.println(String.format(output, ++count, id,
				 * libelle, reference, prix, url_image));
				 */
			}
		} catch (SQLException e) {
			throw new StockageException(e);
		}
		return null;
	}

	@Override
	public void save(Pizza t) throws StockageException {

	}

	@Override
	public void update(String codePizza, Pizza t) throws StockageException {

	}

	@Override
	public void delete(String codePizza) throws StockageException {

	}

}
