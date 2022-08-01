package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Hibernateutil.HibernateUtil;
import Pojoutil.ClassUtil;
import Pojoutil.StudentUtil;
import Pojoutil.SubjectUtil;
import Pojoutil.TeacherUtil;
import pojos.Classes;
import pojos.Student;
import pojos.Subjects;
import pojos.Teacher;

/**
 * Servlet implementation class MappingServlet
 */
@WebServlet("/MappingServletSub")
public class MappingServletSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MappingServletSub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html"); 
	       PrintWriter out=response.getWriter();

	    String stid,cid;
	    stid=request.getParameter("studentId");
	    cid=request.getParameter("classId");
	    
	     if(stid==null||stid.equals(""))
	    {
	    	out.print("<br>Enter Student id correctly<br>");
		       request.getRequestDispatcher("./MappingOfStudentandClass.jsp").include(request, response);

	    }
	    else if(cid==null||cid.equals(""))
	    {
	    	out.print("<br>Enter class id correctly<br>");
		       request.getRequestDispatcher("./MappingOfStudentandClass.jsp").include(request, response);

	    }
	    else {
	    
	       int classid=Integer.parseInt(cid);
	       int Studentid=Integer.parseInt(stid);
	       
	       Classes clazz=ClassUtil.getClassById(classid);
	       Student student=StudentUtil.getStudentById(Studentid);
	       
	        student.setAssignedClasses(clazz);   
	       
	       //SessionFactory sf=new HibernateUtil().getSessionFactory();
	       //Session session=sf.openSession();
	       Session session=new HibernateUtil().getSessionFactory();
	        Transaction tx=session.beginTransaction();
	       session.update(student);
	       tx.commit();
	       out.print("<br/>mapping of student with class is sucessful<br/>");
	       request.getRequestDispatcher("./MappingOfStudentandClass.jsp").include(request, response);
	    }
	       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
