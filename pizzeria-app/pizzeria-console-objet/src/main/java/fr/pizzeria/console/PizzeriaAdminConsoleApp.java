package fr.pizzeria.console;

//import java.util.ResourceBundle;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuPizza;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {
		throw new IllegalAccessError("Utility class");
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		// ResourceBundle resourceBundle =
		// ResourceBundle.getBundle("application");

		// String daoImpl = resourceBundle.getString("dao.impl");

		// IDao<Pizza, String> daoImplInstance = (IDao<Pizza, String>)
		// Class.forName(daoImpl).newInstance();

		IDao<Pizza, String> daoImplInstance = new PizzaDaoJpa();

		IhmTools ihmTools = new IhmTools(daoImplInstance);

		Menu menu = new MenuPizza("**** Pizzeria Administration ****", ihmTools);
		menu.executer();

		System.out.println("\nAu revoir, à bientot !");
		ihmTools.getSc().close();

	}
}