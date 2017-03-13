package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IDao<Pizza, String> {

	private EntityManagerFactory emf;

	public PizzaDaoJpa() {
		emf = Persistence.createEntityManagerFactory("tanguy-pizzeria");
	}

	@Override
	public List<Pizza> read() throws StockageException {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Pizza> query = em.createNamedQuery("pizza.findAllPizzas", Pizza.class);
		List<Pizza> pizzas = query.getResultList();

		em.close();

		return pizzas;
	}

	@Override
	public void create(Pizza p) throws StockageException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(p);

		et.commit();
		em.close();

	}

	@Override
	public void update(String code, Pizza p) throws StockageException {

		EntityManager em = emf.createEntityManager();
		p.setId(getByCode(code, em).getId());
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.merge(p);

		et.commit();
		em.close();

	}

	@Override
	public void delete(String code) throws StockageException {
		EntityManager em = emf.createEntityManager();
		Pizza pizza = getByCode(code, em);
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.remove(pizza);

		et.commit();
		em.close();

	}

	private Pizza getByCode(String code, EntityManager em) {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.getById", Pizza.class);

		query.setParameter("code", code);
		Pizza pizza = query.getSingleResult();
		return pizza;
	}
}
