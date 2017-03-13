package fr.pizzeria.client;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuClient;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

public class AppClient {

	private AppClient() {
		throw new IllegalAccessError("Utility class");
	}

	public static void main(String[] args) {

		IDao<Pizza, String> daoImplInstance = new PizzaDaoJpa();

		IhmTools ihmTools = new IhmTools(daoImplInstance);

		Menu menu = new MenuClient("**** Pizzeria Client ****", ihmTools);
		menu.executer();

	}

}
