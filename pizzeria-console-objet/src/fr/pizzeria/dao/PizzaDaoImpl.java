package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	private Pizza[] allPizzas;

	public PizzaDaoImpl() {
	}

	@Override
	public Pizza[] findAllPizzas() {
		return allPizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza newPizza) {

		int newLength = allPizzas.length + 1;
		Pizza[] newAllPizzas = new Pizza[newLength];
		System.arraycopy(allPizzas, 0, newAllPizzas, 0, newLength);
		newAllPizzas[allPizzas.length] = newPizza;
		allPizzas = newAllPizzas;
		Pizza.nbPizzas++;

		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		return false;
	}

}
