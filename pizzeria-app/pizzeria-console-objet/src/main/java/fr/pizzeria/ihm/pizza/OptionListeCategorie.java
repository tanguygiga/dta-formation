package fr.pizzeria.ihm.pizza;

import java.util.stream.Collectors;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

public class OptionListeCategorie extends OptionMenu {

	private IDao<Pizza, String> dao;

	public OptionListeCategorie(IDao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Pizzas par categories";
	}

	@Override
	public void execute() {
		this.dao.read().stream().collect(Collectors.groupingBy(Pizza::getCategorie)).forEach((k, v) -> {
			System.out.println(k);
			v.stream().forEach(System.out::println);
			System.out.println();
		});

	}

}
