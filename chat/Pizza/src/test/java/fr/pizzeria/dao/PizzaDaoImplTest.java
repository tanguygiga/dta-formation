package fr.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {
	private PizzaDaoImplTableau pizzaDao;

	@Before
	public void setUp() {
		pizzaDao = new PizzaDaoImplTableau();
	}

	@Test
	public void test_find_all() {
		List<Pizza> pizzas = pizzaDao.findAllPizzas();

		Assert.assertEquals(9, pizzas.size());
	}

	@Test(expected = SaveDaoException.class)
	public void test_save_invalid_data() throws SaveDaoException {
		Pizza pizza = new Pizza(0, null, null, 0, null);
		pizzaDao.saveNewPizza(pizza);
		List<Pizza> all = pizzaDao.findAllPizzas();
		assertEquals(8, all.size());
		assertThat(all.size(), matcher);

	}
}
