package fr.pizzeria.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Ingredient;

@Controller
@RequestMapping("/ingredient")
public class IngredientControllerCrud {

	@Autowired
	IDao<Ingredient, String> ingredientService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listIngredient() {
		ModelAndView mav = new ModelAndView();
		List<Ingredient> ingredients = ingredientService.read();
		mav.addObject("ingredients", ingredients);
		mav.setViewName("ingredient");
		return mav;

	}

}
