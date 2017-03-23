package fr.pizzeria.admin.metier;

import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.tool.event.CreatePizzaEvent;
import fr.pizzeria.admin.tool.event.DeletePizzaEvent;
import fr.pizzeria.admin.tool.event.UpdatePizzaEvent;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private Event<CreatePizzaEvent> cpe;

	@Inject
	private Event<UpdatePizzaEvent> upe;

	@Inject
	private Event<DeletePizzaEvent> dpe;

	@Inject
	private IDao<Pizza, String> pizzaDao;

	public List<Pizza> read() {
		return pizzaDao.read();
	}

	public void create(Pizza pizza) {
		pizzaDao.create(pizza);
		cpe.fire(new CreatePizzaEvent(pizza));

	}

	public void update(String code, Pizza pizza) {
		pizzaDao.update(code, pizza);
		upe.fire(new UpdatePizzaEvent(pizza));
	}

}
