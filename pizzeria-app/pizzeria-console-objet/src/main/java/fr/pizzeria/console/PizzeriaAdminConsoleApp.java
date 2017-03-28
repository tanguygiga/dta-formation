package fr.pizzeria.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {
		throw new IllegalAccessError("Utility class");
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PizzeriaConfig.class);) {

			Menu menu = context.getBean(Menu.class);
			menu.executer();

			System.out.println("Au revoir, à bientot !");

		}
	}
}