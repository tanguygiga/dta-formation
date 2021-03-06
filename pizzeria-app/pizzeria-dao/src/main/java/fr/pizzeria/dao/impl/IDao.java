package fr.pizzeria.dao.impl;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Ingredient;

public interface IDao<T, E> {

	void create(T t) throws StockageException;

	List<T> read() throws StockageException;

	void update(String code, T t) throws StockageException;

	void delete(String code) throws StockageException;

	default void populate() throws StockageException, DaoException {
		throw new DaoException("Pas encore implémentée");
	}

	default Ingredient get(String code) throws StockageException, DaoException {
		throw new DaoException("Pas encore implémentée");

	};

}
