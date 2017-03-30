package fr.pizzeria.dao.aspects;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.config.DaoConfigTest;
import fr.pizzeria.dao.datajpa.PizzaRepository;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfigTest.class)
public class GreffonCodeDepuisNomTest {

	@Autowired
	IDao<Pizza, String> pizzaDao;
	@Autowired
	PizzaRepository pizzaRep;

	@Test
	public void testSiCodeVideAlorsNomCreate() throws DaoException {

		// invoquer create
		pizzaDao.create(new Pizza("", "abcdef", 8.90, CategoriePizza.VEGETARIEN));

		// vérifier create
		assertTrue(pizzaDao.read().stream().anyMatch(p -> "ABC".equals(p.getCode())));

		pizzaDao.delete("ABC");
	}

	@Test
	public void testSiCodeVideAlorsNomUpdate() throws DaoException {

		pizzaDao.create(new Pizza("ZYX", "zyxwvu", 8.90, CategoriePizza.VEGETARIEN));

		// invoquer
		pizzaDao.update("ZYX", new Pizza("", "abcdef", 8.90, CategoriePizza.VEGETARIEN));

		// vérifier update
		assertTrue(pizzaDao.read().stream().anyMatch(p -> "ABC".equals(p.getCode())));

		pizzaDao.delete("ABC");
		// assertTrue(pizza == null);

	}

}
