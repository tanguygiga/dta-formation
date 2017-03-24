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

		Pizza pizza = pizzaEJB.find(request.getParameter("code"));
		request.setAttribute("updatePizza", pizza);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp").forward(request,
				response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(request.getParameter("categorie"));

		String old_code = request.getParameter("old_code");
		Pizza pizza = new Pizza(code, nom, prix, categorie);

		pizzaEJB.update(old_code, pizza);
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}

}
