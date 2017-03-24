package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.tool.event.PizzaEvent;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private Event<PizzaEvent> pe;

	@EJB
	PizzaServiceEJB pizzaEJB;

	public List<Pizza> read() {
		return pizzaEJB.read();
	}

	public void create(Pizza pizza) {
		pizzaEJB.create(pizza);
		pe.fire(new PizzaEvent(pizza));
	}

	public void update(String code, Pizza pizza) {
		pizzaEJB.update(code, pizza);
		pe.fire(new PizzaEvent(pizza));
	}

	public void delete(String code) throws DaoException {

		Pizza pizza = this.find(code);

		pizzaEJB.delete(code);
		pe.fire(new PizzaEvent(pizza));
	}

	public Pizza find(String code) throws DaoException {

		return pizzaEJB.find(code);
	}

}
