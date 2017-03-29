package fr.pizzeria.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.impl.DaoConfigTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfigTest.class)
public class PizzaDaoJdbcSpringTest {

	@Autowired
	private IDao<Pizza, String> pizzaDao;

	@Before
	public void init() {

	}

	@Test
	public void test_create() {
		pizzaDao.create(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
	}

	@Test
	public void test_read() {
		pizzaDao.read();
	}

	@Test
	public void test_update() {

		pizzaDao.update("CAL", new Pizza("CRI", "CriDeDesespoir", 69.82, CategoriePizza.POISSON));

	}
}
