package fr.pizzeria.dao.DataJpa;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
@Transactional
public class PizzaDaoImplDataJpa implements IDao<Pizza, String> {

	@Autowired
	PizzaRepository pizzaRep;

	@Override
	@PostConstruct
	public void populate() throws StockageException {
		pizzaRep.save(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		pizzaRep.save(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN));
		pizzaRep.save(new Pizza("REI", "Reine", 11.50, CategoriePizza.VIANDE));
		pizzaRep.save(new Pizza("FRO", "4 Fromages", 12.00, CategoriePizza.VEGETARIEN));
		pizzaRep.save(new Pizza("CAN", "Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzaRep.save(new Pizza("SAV", "Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzaRep.save(new Pizza("ORI", "Orientale", 13.50, CategoriePizza.VIANDE));
		pizzaRep.save(new Pizza("SAU", "Saumonette", 14.00, CategoriePizza.POISSON));
	}

	@Override
	public void create(Pizza t) throws StockageException {
		pizzaRep.save(t);
	}

	@Override
	public List<Pizza> read() throws StockageException {
		return pizzaRep.findAll();
	}

	@Override
	public void update(String code, Pizza t) throws StockageException {
		t.setId(pizzaRep.findByCode(code).get(0).getId());
		pizzaRep.save(t);

	}

	@Override
	public void delete(String code) throws StockageException {
		pizzaRep.delete(pizzaRep.findByCode(code).get(0).getId());
	}

}
