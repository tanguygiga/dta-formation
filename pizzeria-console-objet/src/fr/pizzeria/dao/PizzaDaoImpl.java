package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	private Pizza[] allPizzas;

	public PizzaDaoImpl(Pizza[] allPizzas) {
		this.allPizzas = allPizzas;
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
	public boolean updatePizza(int idPizza, Pizza newPizza) {
		int index = 0;
		for (Pizza pizza : allPizzas) {
			if (idPizza == (pizza.getId())) {
				allPizzas[index] = newPizza;
				return true;
			}
			index++;
		}
		return false;
	}

	@Override
	public boolean deletePizza(int idPizza) {
		int index = 0;
		for (Pizza pizza : allPizzas) {
			if (idPizza == (pizza.getId())) {
				Pizza[] newAllPizzas = new Pizza[allPizzas.length - 1];
				System.arraycopy(allPizzas, 0, newAllPizzas, 0, index);
				System.arraycopy(allPizzas, index + 1, newAllPizzas, index, allPizzas.length - index - 1);
				allPizzas = newAllPizzas;
				Pizza.nbPizzas--;
				return true;
			}
			index++;
		}
		return false;
	}

}
