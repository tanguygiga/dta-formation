package fr.pizzeria.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Ingredient;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired
	IDao<Ingredient, String> ingredientService;

	@RequestMapping(value = "/ingredient/{code}", method = RequestMethod.GET)
	public Ingredient get(@PathVariable String code) throws DaoException {
		return ingredientService.get(code);
	}

}
