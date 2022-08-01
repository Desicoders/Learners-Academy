package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Hibernateutil.HibernateUtil;
import pojos.Admin;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(urlPatterns = { "/k" })
public class AdminFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AdminFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("*************through filter***********8");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		response.setContentType("text/html");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(password);
		String role = request.getParameter("role");
		HibernateUtil util = new HibernateUtil();
		//SessionFactory sf = util.getSessionFactory();
		//Session s = sf.openSession();
		Session s=util.getSessionFactory();
		PrintWriter out = response.getWriter();
		out.print("<h2>through filter</h2><br/>");
		if (role.equals("admin")) {
			Admin admin = s.find(Admin.class, name);
			if (admin == null) {
				out.print("<h1> Incorrect Role or Username</h1>");
				request.getRequestDispatcher("/").include(request, response);
			} else if (!admin.getPassword().equals(password)) {
				out.print("<h1> Incorrect Password</h1>");
				request.getRequestDispatcher("/").include(request, response);
			} else if (admin.getPassword().equals(password)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("role", "admin");
				session.setAttribute("user", admin);
				out.print("<h1> Login sucessful for " + admin.getName() + " as " + role + " </h1>");

				chain.doFilter(request, response);

			}

		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
