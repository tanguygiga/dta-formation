package fr.pizzeria.admin.tool.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PizzaService pizzaDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("pizzas", pizzaDao.read());

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp").forward(request,
				response);
	}

}
