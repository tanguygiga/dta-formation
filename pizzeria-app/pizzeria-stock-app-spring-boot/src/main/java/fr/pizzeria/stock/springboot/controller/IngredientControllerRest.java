package fr.pizzeria.stock.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.dao.impl.IDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Ingredient;

@RestController
@RequestMapping("/rest/ingredient")
public class IngredientControllerRest {

	@Autowired
	IDao<Ingredient, String> ingredientService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ingredient> read() {
		return ingredientService.read();

	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public Ingredient get(@PathVariable String code) throws DaoException {
		return ingredientService.get(code);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.POST)
	public void createIngredient(@RequestBody Ingredient t) {
		ingredientService.create(t);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.PUT)
	public void updateIngredient(@PathVariable String code, @RequestBody Ingredient t) {
		ingredientService.update(code, t);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public void deleteIngredient(@PathVariable String code) {
		ingredientService.delete(code);
	}

}
