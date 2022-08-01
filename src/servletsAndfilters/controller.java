package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Hibernateutil.HibernateUtil;
import pojos.Admin;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	     String name=request.getParameter("username")   ;
	     String password=request.getParameter("password");
	     System.out.println(password);
	     String role=request.getParameter("role");
	     HibernateUtil util=new HibernateUtil();
	    //SessionFactory sf=util.getSessionFactory();
	    //Session s=sf.openSession();
	     Session s=util.getSessionFactory();
	     PrintWriter out=response.getWriter();
	     if(role.equals("admin"))
	     {
	    	 Admin admin=s.find(Admin.class,name);
	    	 if(admin==null) {
	    		 out.print("<h1> Incorrect Role or Username</h1>");
	    		 request.getRequestDispatcher("/").include(request, response);
	    	 }
	    	 else if(!admin.getPassword().equals(password)) {
	    		 out.print("<h1> Incorrect Password</h1>");
	    		 request.getRequestDispatcher("/").include(request, response);
	    	 }
	    	 else if(admin.getPassword().equals(password))
	    	 {
	    		HttpSession session=request.getSession(true);
	    		session.setAttribute("role","admin");
	    		session.setAttribute("user",admin);
	    		out.print("<h1> Login sucessful for "+admin.getName()+" as "+role+" </h1>");

	    		request.getRequestDispatcher("./Admin.jsp").forward(request, response);
	    		 
	    	 
	    	 }
	    	 
	    }
	}

}
