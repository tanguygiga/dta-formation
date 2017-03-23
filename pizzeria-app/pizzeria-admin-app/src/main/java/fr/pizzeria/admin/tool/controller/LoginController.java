package fr.pizzeria.admin.tool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
			response.sendRedirect(request.getContextPath() + "/pizzas/list");

		} else {
			request.setAttribute("connected", false);
			this.getServletContext().getRequestDispatcher(loginURI).forward(request, response);

		}
	}

}
