package fr.pizzeria.admin.tool.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.admin.tool.ImportData;
import fr.pizzeria.model.Pizza;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginURI = request.getContextPath() + "/login";

		String mail = request.getParameter("email");
		String pass = request.getParameter("password");

		if ("admin@pizzeria.fr".equals(mail) && "admin".equals(pass)) {
			request.getSession().setAttribute("connected", true);
			request.getSession().setAttribute("email", "admin@pizzeria.fr");
			ImportData importData = new ImportData();
			List<Pizza> pizzas = importData.importer();

			for (Pizza pizza : pizzas) {
				pizzaEJB.create(pizza);

			}
			response.sendRedirect(request.getContextPath() + "/pizzas/list");

		} else {
			request.setAttribute("connected", false);
			this.getServletContext().getRequestDispatcher(loginURI).forward(request, response);

		}
	}

}
