package fr.pizzeria.admin.tool;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public interface DaoTools {

	IDao<Pizza, String> DEFAULT_PIZZA_DAO = new PizzaDaoImpl();

}
