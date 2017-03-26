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

@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oldCode = request.getParameter("code");
		request.setAttribute("pizza", pizzaEJB.find(oldCode));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp").forward(request,
				response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oldCode = request.getParameter("oldCode");

		String newCode = request.getParameter("newCode");
		String nom = request.getParameter("nom");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(request.getParameter("categorie"));

		pizzaEJB.update(oldCode, new Pizza(newCode, nom, prix, categorie));
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}

}
