package fr.pizzeria.ihm.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.impl.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.PizzaTools;
import fr.pizzeria.model.Pizza;

@Controller
public class CreatePizza extends OptionMenu {

	private IDao<Pizza, String> dao;
	private PizzaTools tools;

	@Autowired
	public CreatePizza(IDao<Pizza, String> dao, PizzaTools tools) {
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
