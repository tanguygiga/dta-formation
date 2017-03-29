package fr.pizzeria.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoJdbcSpring implements IDao<Pizza, String> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaDaoJdbcSpring(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void create(Pizza p) {
		String sql = "INSERT INTO PIZZA (code,nom,prix,categorie) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, p.getCode(), p.getNom(), p.getPrix(), p.getCategorie().name());
	}

	@Override
	public List<Pizza> read() throws StockageException {
		String sql = "SELECT * FROM pizza";
		return this.jdbcTemplate.query(sql, (rs, i) -> new Pizza(rs.getString("code"), rs.getString("nom"),
				rs.getDouble("prix"), CategoriePizza.valueOf(rs.getString("categorie"))));
	}

	@Override
	public void update(String code, Pizza p) throws StockageException {
		String sql = "UPDATE pizza SET nom=?, nom=?, prix =?, categorie=? WHERE code=? ";
		this.jdbcTemplate.update(sql, p.getCode(), p.getNom(), p.getPrix(), p.getCategorie().name(), code);
	}

	@Override
	public void delete(String code) throws StockageException {
		String sql = "DELETE FROM pizza WHERE code = ?";
		this.jdbcTemplate.update(sql, code);
	}

}
