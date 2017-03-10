package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.StockageException;

public interface IDao<T, E> {
	List<T> findAll() throws StockageException;

	void save(T t) throws StockageException;

	void update(String codePizza, T t) throws StockageException;

	void delete(String codePizza) throws StockageException;

	default void importData(IDao<T, String> source) throws DaoException {
		throw new DaoException("Pas encore implémentée");
	}
}
