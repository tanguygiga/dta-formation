package fr.pizzeria.ihm.pizza;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.PizzaTools;
import fr.pizzeria.model.Pizza;

public class OptionUpdatePizza extends OptionMenu {

	private IDao<Pizza, String> dao;
	private Scanner scanner;
	private PizzaTools tools;

	public OptionUpdatePizza(IDao<Pizza, String> dao, Scanner scanner, PizzaTools tools) {
		this.dao = dao;
		this.scanner = scanner;
		this.tools = tools;
	}

	@Override
	public String getLibelle() {
		return "Modifier une pizza";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez choisir le code de la pizza a modifier (EXIT pour abandonner)");
		String pizzaPick = this.scanner.nextLine().toUpperCase();
		if (pizzaPick != "EXIT") {

			try {
				this.dao.update(pizzaPick, this.tools.saisir());
			} catch (StockageException e) {
				throw new StockageException(e + "\n!!! Code incorrect, cette pizza n'existe pas");
			}
		}
	}

}
