package fr.pizzeria.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.console.PizzeriaConfig;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzeriaConfig.class)
public class PizzaDaoTest {

	@Autowired
	private IDao<Pizza, String> pizzaDao;

	@Test
	public void testRead() throws DaoException {
		List<Pizza> pizzas = new ArrayList<>();
		pizzas = pizzaDao.read();
		assertTrue(pizzas.size() == 8);
	}

}