package fr.pizzeria.model;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.PizzaDaoImpl;

public class PizzaDaoImplTest {
	PizzaDaoImpl dao;

	@Before
	public void setUp() {
		dao = new PizzaDaoImpl();
	}

	@Test
	public void testFindAll() {
		List<Pizza> pizzas = dao.findAll();
		assertThat(pizzas.size(), anyOf(is(8), is(9)));
	}

	@Test
	public void testEquals() {
		Pizza p1 = new Pizza("GRE", "gredue", (double) 0, CategoriePizza.VIANDE);
		Pizza p2 = new Pizza("GRE", "grebel", 4.5, CategoriePizza.VEGETARIEN);
		Pizza p3 = new Pizza("GAB", "gabrie", (double) 0, CategoriePizza.VIANDE);
		assertTrue(p1.equals(p1));
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));
	}

}
