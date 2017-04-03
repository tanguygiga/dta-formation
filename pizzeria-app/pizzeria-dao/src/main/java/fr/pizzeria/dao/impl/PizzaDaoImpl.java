package fr.pizzeria.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IDao<Pizza, String> {

	private List<Pizza> pizzas = new ArrayList<>();

	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("REI", "Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "4 Fromages", 12.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("CAN", "Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "Orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAU", "Saumonette", 14.00, CategoriePizza.POISSON));
		Collections.sort(pizzas);
	}

	@Override
	public List<Pizza> read() {
		return pizzas;
	}

	@Override
	public void create(Pizza pizza) {
		try {
			pizzas.add(pizza);
			Collections.sort(pizzas);
		} catch (Exception e) {
			throw new SaveException(e);
		}
	}

	public Optional<Pizza> find(String code) {
		return pizzas.stream().filter(p -> code.equalsIgnoreCase(p.getCode())).findFirst();
	}

	@Override
	public void update(String code, Pizza maj) {
		Pizza p = find(code).get();
		Integer id = pizzas.indexOf(p);
		if (id > -1) {
			pizzas.set(id, maj);

			System.out.println("Les modifications sont les suivantes :");
			if (code != maj.getCode())
				System.out.println("Code :\n" + code + " --> " + maj.getCode() + "\n");

			if (!p.getNom().equals(maj.getNom()))
				System.out.println("Nom :\n" + p.getNom() + " --> " + maj.getNom() + "\n");

			if (!(p.getPrix() == maj.getPrix()))
				System.out.println("Prix :\n" + p.getPrix() + " --> " + maj.getPrix() + "\n");

			if (!p.getCategorie().equals(maj.getCategorie()))
				System.out.println("Catégorie :\n" + p.getCategorie() + " --> " + maj.getCategorie() + "\n");

			Collections.sort(pizzas);

		} else {
			throw new UpdateException();
		}
	}

	@Override
	public void delete(String code) {
		Pizza p = find(code).get();
		Integer id = pizzas.indexOf(p);
		if (id > -1) {
			pizzas.remove(p);
			System.out.println("La pizza " + p.getNom() + " a été supprimée !\n");

		} else {
			throw new DeleteException();
		}
	}

}
