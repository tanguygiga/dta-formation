package fr.pizzeria.admin.tool.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebListener
public class SessionListener implements ServletContextListener {

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		List<Pizza> pizzas = new ArrayList<>();

		pizzas.add(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("REI", "Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "4 Fromages", 12.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("CAN", "Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "Orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAU", "Saumonette", 14.00, CategoriePizza.POISSON));
		Collections.sort(pizzas);

		for (Pizza pizza : pizzas) {
			pizzaEJB.create(pizza);
		}

	}

}
