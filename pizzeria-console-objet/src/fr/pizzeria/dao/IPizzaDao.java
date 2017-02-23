package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	Pizza[] findAllPizzas();

	boolean saveNewPizza(Pizza newPizza);

	boolean updatePizza(int idPizza, Pizza pizza);

	boolean deletePizza(int idPizza);

}