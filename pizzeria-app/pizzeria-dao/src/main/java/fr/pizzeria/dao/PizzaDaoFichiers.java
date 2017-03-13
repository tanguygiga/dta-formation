package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichiers implements IDao<Pizza, String> {

	@Override
	public List<Pizza> read() {
		List<Pizza> pizzas = new ArrayList<>();
		try {
			Files.list(Paths.get("data")).forEach(path -> extractPizzasFromFile(path));
		} catch (IOException e) {
			throw new StockageException(e);
		}
		return pizzas;
	}

	private List<Pizza> extractPizzasFromFile(Path path) {
		List<Pizza> pizzas = new ArrayList<>();
		try {
			String[] pizzaStr = Files.readAllLines(path).get(0).split(";");
			pizzas.add(new Pizza(pizzaStr[0], pizzaStr[1], Double.parseDouble(pizzaStr[2]), CategoriePizza.VIANDE));
		} catch (IOException e) {
			throw new StockageException(e);
		}
		return pizzas;
	}

	@Override
	public void create(Pizza newPizza) {
		try {
			Files.write(Paths.get(newPizza.getCode(), ".txt"), newPizza.toString().getBytes(),
					StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			throw new SaveException(e);
		}

	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		delete(codePizza);
		create(newPizza);
	}

	@Override
	public void delete(String codePizza) {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			throw new DeleteException(e);
		}

	}
}
