package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoSpringJpa implements IDao<Pizza, String> {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void create(Pizza p) {
		em.persist(p);
	}

	@Override
	@Transactional
	public List<Pizza> read() throws StockageException {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.readAll", Pizza.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(String code, Pizza p) throws StockageException {
		Integer id = find(code).getId();
		p.setId(id);
		em.merge(p);
	}

	@Override
	@Transactional
	public void delete(String code) throws StockageException {
		em.remove(find(code));
	}

	private Pizza find(String code) {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.getByCode", Pizza.class);
		query.setParameter("code", code);
		Pizza pizza = query.getSingleResult();
		return pizza;
	}

}
