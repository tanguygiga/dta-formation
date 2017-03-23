package fr.pizzeria.admin.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import fr.pizzeria.model.Log;

/**
 * Servlet Filter implementation class TimerFilter
 */
@WebFilter(urlPatterns = { "/*" })
public class TimerFilter implements Filter {

	private FilterConfig config = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;

		config.getServletContext().log("TimerFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();

		List<Log> log = (List<Log>) config.getServletContext().getAttribute("logs");
		if (log == null) {
			log = new ArrayList<Log>();
		}
		log.add(new Log(path, after, before));
		config.getServletContext().setAttribute("logs", log);

	}

	@Override
	public void destroy() {
	}
}
