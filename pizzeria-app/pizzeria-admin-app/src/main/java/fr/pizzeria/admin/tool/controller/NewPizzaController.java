package fr.pizzeria.admin.tool.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/new")
public class NewPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/newPizza.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(request.getParameter("categorie"));

		Pizza pizza = new Pizza(code, nom, prix, categorie);

		pizzaEJB.create(pizza);
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}

}
