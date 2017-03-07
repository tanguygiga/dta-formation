package fr.pizzeria.ihm;

import java.util.ResourceBundle;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public class App {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		System.out.println(daoImpl);
		IDao<Pizza, String> instanceDaoImpl = (IDao<Pizza, String>) Class.forName(daoImpl).newInstance();

		System.out.println(instanceDaoImpl.findAllPizzas());

		/*
		 * Pizza p1 = new Pizza(12, "RTE", "la meilleure pizza", 78.25,
		 * CategoriePizza.VIANDE);
		 * 
		 * Pizza p2 = new Pizza(12, "RTE", "la meilleure pizza", 78.25,
		 * CategoriePizza.VIANDE);
		 * 
		 * System.out.println(p1.equals(p2));
		 */
		Menu.menuPrincipal();

	}
}
