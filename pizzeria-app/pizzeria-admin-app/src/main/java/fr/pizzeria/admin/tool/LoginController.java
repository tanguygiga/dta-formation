package fr.pizzeria.admin.tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("admin@pizzeria.fr".equals(request.getParameter("email"))
				&& "admin".equals(request.getParameter("password"))) {
			request.getSession().setAttribute("connected", true);
			request.getSession().setAttribute("email", "admin@pizzeria.fr");
			response.sendRedirect(request.getContextPath() + "/pizzas/list");

		} else {
			request.setAttribute("connected", false);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/login.jsp").forward(request, response);

		}
	}

}
