package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.Optional;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.tool.event.PizzaEvent;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private Event<PizzaEvent> pe;

	@Inject
	private IDao<Pizza, String> pizzaDao;

	public List<Pizza> read() {
		return pizzaDao.read();
	}

	public void create(Pizza pizza) {
		pizzaDao.create(pizza);
		pe.fire(new PizzaEvent(pizza));
	}

	public void update(String code, Pizza pizza) {
		pizzaDao.update(code, pizza);
		pe.fire(new PizzaEvent(pizza));
	}

	public void delete(String code) throws DaoException {
		Optional<Pizza> optPizza = pizzaDao.find(code);
		Pizza pizza = null;
		if (optPizza.isPresent()) {
			pizza = optPizza.get();
		}
		pizzaDao.delete(code);
		pe.fire(new PizzaEvent(pizza));
	}

	public Optional<Pizza> find(String code) throws DaoException {
		return pizzaDao.find(code);
	}

}
