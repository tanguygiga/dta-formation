package fr.pizzeria.admin.tool.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class DaoProducer {

	@Produces
	@ApplicationScoped
	public IDao<Pizza, String> pizzaDao() {
		return new PizzaDaoImpl();
	}
}
