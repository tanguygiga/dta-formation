package fr.pizzeria.admin.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ImportData {

	@EJB
	private PizzaServiceEJB pizzaEJB;

	List<Pizza> pizzas = new ArrayList<>();

	public ImportData() {

		pizzas.add(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 Fromage", 12.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'Orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAU", "La Saumonette", 14.00, CategoriePizza.POISSON));
		Collections.sort(pizzas);

	}

	public List<Pizza> importer() {
		return pizzas;
		
	}
}