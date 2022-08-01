package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Hibernateutil.HibernateUtil;
import pojos.Student;
import pojos.Subjects;

/**
 * Servlet implementation class addSubject
 */
@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name=request.getParameter("name");
		Student student=new Student(name);
		//SessionFactory sf= new HibernateUtil().getSessionFactory();
		//Session S=sf.openSession();
		Session S=new HibernateUtil().getSessionFactory();
		Transaction tx=S.beginTransaction();
		S.save(student);
		tx.commit();
		//S.close();
	    PrintWriter out=response.getWriter();
	    out.print("Student Saved");
	    request.getRequestDispatcher("./AddStudents.jsp").include(request, response);
		
	}

	

}
