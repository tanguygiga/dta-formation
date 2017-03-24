package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IDao<Pizza, String> {

	private List<Pizza> pizzas = new ArrayList<>();

	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromage", 12.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAU", "La saumonette", 14.00, CategoriePizza.POISSON));
		Collections.sort(pizzas);
	}

	@Override
	public List<Pizza> read() {
		return pizzas;
	}

	@Override
	public void create(Pizza pizza) {
		try {
			pizzas.add(pizza);
			Collections.sort(pizzas);
		} catch (Exception e) {
			throw new SaveException(e);
		}
	}

	@Override
	public Optional<Pizza> find(String code) {
		for (Pizza pizza : pizzas) {
			if (code.equalsIgnoreCase(pizza.getCode())) {
				return Optional.of(pizza);
			}
		}
		return Optional.empty();
	}

	@Override
	public void update(String code, Pizza pizza) {
		Optional<Pizza> p = find(code);
		int id = pizzas.indexOf(p);

		if (id > -1) {
			pizzas.set(id, pizza);
			Collections.sort(pizzas);
		} else {
			throw new UpdateException();
		}

	}

	@Override
	public void delete(String code) {
		Optional<Pizza> p = find(code);
		int id = pizzas.indexOf(p);

		if (id > -1) {
			pizzas.remove(id);
		} else {
			throw new DeleteException();
		}
	}

}
