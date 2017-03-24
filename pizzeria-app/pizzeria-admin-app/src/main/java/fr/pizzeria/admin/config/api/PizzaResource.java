package fr.pizzeria.admin.config.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {

	@EJB
	private PizzaServiceEJB ejb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> list() {

		return ejb.read();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Pizza p) {
		ejb.create(p);
	}

}
