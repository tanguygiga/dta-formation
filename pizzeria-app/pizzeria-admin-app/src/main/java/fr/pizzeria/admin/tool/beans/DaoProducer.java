package fr.pizzeria.admin.tool.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.impl.IDao;
import fr.pizzeria.dao.impl.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class DaoProducer {

	@Produces
	@ApplicationScoped
	public IDao<Pizza, String> pizzaDao() {
		return new PizzaDaoImpl();
	}
}
