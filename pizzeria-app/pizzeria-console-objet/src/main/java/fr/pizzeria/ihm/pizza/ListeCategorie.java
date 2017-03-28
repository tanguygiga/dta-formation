package fr.pizzeria.ihm.pizza;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

@Controller
public class ListeCategorie extends OptionMenu {

	private IDao<Pizza, String> dao;

	@Autowired
	public ListeCategorie(IDao<Pizza, String> dao) {
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
