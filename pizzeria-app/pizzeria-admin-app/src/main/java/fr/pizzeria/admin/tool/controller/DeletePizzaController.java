package fr.pizzeria.admin.tool.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;

@WebServlet("/pizzas/delete")
public class DeletePizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PizzaServiceEJB pizzaEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");

		pizzaEJB.delete(code);
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}

}
