package fr.pizzeria.console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {
		throw new IllegalAccessError("Utility class");
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");) {

			Menu menu = context.getBean(Menu.class);
			menu.executer();

			System.out.println("\nAu revoir, à bientot !");

		}
	}
}