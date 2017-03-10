package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IDao<Pizza, String> {

	EntityManagerFactory emf;

	public PizzaDaoJpa() {
		emf = Persistence.createEntityManagerFactory("Pizza");
	}

	@Override
	public List<Pizza> findAll() throws StockageException {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Pizza> query = em.createQuery("select p from pizza p where p.nom='nom2'", Pizza.class);
		List<Pizza> pizzas = query.getResultList();

		return pizzas;
	}

	@Override
	public void save(Pizza t) throws StockageException {

	}

	@Override
	public void update(String codePizza, Pizza t) throws StockageException {

	}

	@Override
	public void delete(String codePizza) throws StockageException {

	}

}
