package fr.pizzeria.admin.metier;

import java.util.List;

import javax.inject.Inject;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private IDao<Pizza, String> pizzaDao;

	public List<Pizza> read() {
		return pizzaDao.read();
	}

}
