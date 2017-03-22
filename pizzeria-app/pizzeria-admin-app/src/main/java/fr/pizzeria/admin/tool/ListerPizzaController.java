package fr.pizzeria.admin.tool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class ListerPizzaController
 */
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IDao<Pizza, String> pizzaDao = DaoTools.DEFAULT_PIZZA_DAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerPizzaController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listPizzas", new PizzaDaoImpl().read());
		List<Pizza> pizzas = pizzaDao.read();
		request.setAttribute("pizzas", pizzas);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
