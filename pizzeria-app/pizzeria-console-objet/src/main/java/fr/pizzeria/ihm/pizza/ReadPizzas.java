package fr.pizzeria.ihm.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.impl.IDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

@Controller
public class ReadPizzas extends OptionMenu {

	private IDao<Pizza, String> dao;

	@Autowired
	public ReadPizzas(IDao<Pizza, String> dao) {
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
