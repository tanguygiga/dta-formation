package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext
	private EntityManager em;

	public List<Pizza> read() {

		TypedQuery<Pizza> query = em.createNamedQuery("pizza.readAll", Pizza.class);

		return query.getResultList();
	}

	public void create(Pizza p) throws StockageException {

		em.persist(p);

	}

	public void update(String code, Pizza p) throws StockageException {

		p.setId(find(code).getId());

		em.merge(p);

	}

	public void delete(String code) throws StockageException {

		Pizza pizza = find(code);

		em.remove(pizza);

	}

	public Pizza find(String code) {
		TypedQuery<Pizza> query = em.createNamedQuery("pizza.getByCode", Pizza.class);

		query.setParameter("code", code);
		Pizza pizza = query.getSingleResult();
		return pizza;
	}

}
