package fr.pizzeria.admin.tool;

import fr.pizzeria.dao.impl.IDao;
import fr.pizzeria.dao.impl.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public interface DaoTools {

	IDao<Pizza, String> DEFAULT_PIZZA_DAO = new PizzaDaoImpl();

}
