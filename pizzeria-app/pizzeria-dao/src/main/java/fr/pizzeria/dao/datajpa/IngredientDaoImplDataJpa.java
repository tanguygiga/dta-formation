package fr.pizzeria.dao.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Ingredient;

public class IngredientDaoImplDataJpa implements IDao<Ingredient, String> {

	@Autowired
	IngredientRepository ingRep;

	@Override
	public void create(Ingredient t) throws StockageException {
		ingRep.save(t);
	}

	@Override
	public List<Ingredient> read() throws StockageException {
		return ingRep.findAll();
	}

	@Override
	public void update(String code, Ingredient t) throws StockageException {
		t.setId(ingRep.findByCode(code).get(0).getId());
		ingRep.save(t);
	}

	@Override
	public void delete(String code) throws StockageException {
		ingRep.delete(ingRep.findByCode(code).get(0).getId());
	}

	@Override
	public Ingredient get(String code) throws StockageException {
		return ingRep.getOne(ingRep.findByCode(code).get(0).getId());

	}
}
