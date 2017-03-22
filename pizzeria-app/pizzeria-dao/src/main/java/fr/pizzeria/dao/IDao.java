package fr.pizzeria.dao;

import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public interface IDao<T, E> {

	void create(T t) throws StockageException;

	List<T> read() throws StockageException;

	void update(String code, T t) throws StockageException;

	void delete(String code) throws StockageException;

	default void importData(IDao<T, String> source) throws DaoException {
		throw new DaoException("Pas encore implémentée");
	}

	default Optional<Pizza> find(String code) throws DaoException {
		throw new DaoException("Pas encore implémentée");
	}
}
