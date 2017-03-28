package fr.pizzeria.ihm.pizza;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.PizzaTools;
import fr.pizzeria.model.Pizza;

public class OptionCreatePizza extends OptionMenu {

	private IDao<Pizza, String> dao;
	private PizzaTools tools;

	public OptionCreatePizza(IDao<Pizza, String> dao, PizzaTools tools) {
		this.dao = dao;
		this.tools = tools;
	}

	@Override
	public String getLibelle() {
		return "Ajouter une pizza";
	}

	@Override
	public void execute() {

		try {
			this.dao.create(tools.saisir());
		} catch (StockageException e) {
			throw new StockageException("\n!!! Une erreur a été enregistrée : " + e);
		}

	}

}
