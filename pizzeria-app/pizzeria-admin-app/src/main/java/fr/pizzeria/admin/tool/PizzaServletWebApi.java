package fr.pizzeria.admin.tool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.impl.IDao;
import fr.pizzeria.dao.impl.PizzaDaoImpl;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
@WebServlet("/api/servlet/pizzas")
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDao<Pizza, String> dao = new PizzaDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PizzaServletWebApi() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		List<Pizza> pizzas = dao.read();
		rp.getWriter().append(pizzas.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		String code = rq.getParameter("code");
		String nom = rq.getParameter("nom");
		String prix = rq.getParameter("prix");
		String cat = rq.getParameter("categorie");

		dao.create(new Pizza(code, nom, Double.valueOf(prix), CategoriePizza.valueOf(cat)));
		rp.setStatus(201);

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		String code = rq.getParameter("code");
		String nom = rq.getParameter("nom");
		String prix = rq.getParameter("prix");
		String cat = rq.getParameter("categorie");

		try {
			dao.update(code, new Pizza(code, nom, Double.valueOf(prix), CategoriePizza.valueOf(cat)));
		} catch (StockageException e) {
			throw new StockageException(e + "\n!!! Code incorrect, cette pizza n'existe pas");
		}
		rp.setStatus(200);

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {

		try {
			dao.delete(rq.getParameter("code"));
		} catch (StockageException e) {
			throw new StockageException(e + "\n!!! Code incorrect, cette pizza n'existe pas");
		}
		rp.setStatus(200);

	}
}
