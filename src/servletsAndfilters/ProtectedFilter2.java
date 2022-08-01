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
@WebFilter(urlPatterns = { "/Admin.jsp" }, dispatcherTypes = { DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ASYNC, DispatcherType.REQUEST, DispatcherType.ERROR })
public class ProtectedFilter2 implements Filter {

	/**
	 * Default constructor.
	 */
	public ProtectedFilter2() {
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
		HttpSession session = request.getSession(true);

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
		out.print("through filter protected<br/>");
		if ((role != null && role.equals("admin")) ||(session.getAttribute("role")!=null && (((String) session.getAttribute("role")).equals("admin")))) {
			Admin admin = (Admin) session.getAttribute("user");

			if (admin == null&&name!=null)
				admin = s.find(Admin.class, name);

			if (admin == null) {
				out.print("<h1> Incorrect Role or Username</h1>");
				request.getRequestDispatcher("/").include(request, response);

			} else if ((!admin.getPassword().equals(password)) && session.getAttribute("user") == null) {
				out.print("<h1> Incorrect Password</h1>");
				request.getRequestDispatcher("/").include(request, response);

			} else if (admin.getPassword().equals(password) || admin != null) {
				session.setAttribute("role", "admin");
				session.setAttribute("user", admin);
				out.print("<h3> Login sucessful for " + admin.getName() + " as " + "Admin" + " </h3>");
				chain.doFilter(request, response);

			}

		} else if (role != null && role.equals("teacher")) {
		} else if (role != null && role.equals("student")) {
		}
		else {
			out.print("<h1>please select correct role</h1>");
			request.getRequestDispatcher("/").include(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
