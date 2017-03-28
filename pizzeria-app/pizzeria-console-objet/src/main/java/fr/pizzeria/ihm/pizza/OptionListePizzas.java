package fr.pizzeria.ihm.pizza;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

public class OptionListePizzas extends OptionMenu {

	private IDao<Pizza, String> dao;

	public OptionListePizzas(IDao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Liste des pizzas";
	}

	@Override
	public void execute() {
		this.dao.read().stream().forEach(System.out::println);
	}

}
