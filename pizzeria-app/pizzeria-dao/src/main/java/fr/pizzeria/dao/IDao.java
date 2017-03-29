package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.StockageException;

public interface IDao<T, E> {

	void create(T t) throws StockageException;

	List<T> read() throws StockageException;

	void update(String code, T t) throws StockageException;

	void delete(String code) throws StockageException;

	default void importData(IDao<T, String> source) throws DaoException {
		throw new DaoException("Pas encore implémentée");
	}

}
