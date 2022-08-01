package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

import Hibernateutil.HibernateUtil;
import Pojoutil.ClassUtil;
import Pojoutil.SubjectUtil;
import Pojoutil.TeacherUtil;
import pojos.Classes;
import pojos.Subjects;
import pojos.Teacher;
import pojos.TeachesAndSubject;

/**
 * Servlet implementation class MappingServlet
 */
@WebServlet("/MappingServletMain")
public class MappingServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MappingServletMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html"); 
	       PrintWriter out=response.getWriter();

	    String cid,sid,tid;
	    cid=request.getParameter("classId");
	    sid=request.getParameter("subjectId");
	    tid=request.getParameter("teacherId");
	    if(cid==null||cid.equals(""))
	    {
	    	out.print("<br>Enter class id correctly<br>");
		       request.getRequestDispatcher("./MappingOfClassTeacherSubject.jsp").include(request, response);

	    }
	    else if(tid==null||tid.equals(""))
	    {
	    	out.print("<br>Enter Teacher id correctly<br>");
		       request.getRequestDispatcher("./MappingOfClassTeacherSubject.jsp").include(request, response);

	    }
	    else if(sid==null||sid.equals(""))
	    {
	    	out.print("<br>Enter Subject id correctly<br>");
		       request.getRequestDispatcher("./MappingOfClassTeacherSubject.jsp").include(request, response);

	    }
	    else {
	    
		int classid=Integer.parseInt(request.getParameter("classId"));
	       int subjectid=Integer.parseInt(request.getParameter("subjectId"));
	       int teacherId=Integer.parseInt(request.getParameter("teacherId"));
	       
	       Classes clazz=ClassUtil.getClassById(classid);	       
	     	      
	      
	       
	       
	       
	       
	       
	       Subjects subject=SubjectUtil.getSubjectById(subjectid);
	       Teacher teacher=TeacherUtil.getTeacherById(teacherId);
	       
	       TeachesAndSubject teachesAndSubject=new TeachesAndSubject(teacher, subject);
	       
	       //testing
	       System.out.println("clazz "+clazz.getId());
	       System.out.println("sub "+subject.getId());
	       System.out.println("teacher"+teacher.getId());
	       
	       
	       Set<TeachesAndSubject> teachesAndSubjectList=clazz.getTeachesAndSubject();
	       if(teachesAndSubjectList==null)
	    	   teachesAndSubjectList=new HashSet<>();
	       teachesAndSubjectList.add(teachesAndSubject);
	       clazz.setTeachesAndSubject(teachesAndSubjectList);
	       
	       
	       //SessionFactory sf=new HibernateUtil().getSessionFactory();

	       
	         //Session session=sf.openSession();
	       Session session=new HibernateUtil().getSessionFactory(); 
	       //session.flush();
	       Transaction tx = session.beginTransaction();
	        session.save(teachesAndSubject);
	       session.update(clazz);
	       tx.commit();
	       out.print("<br/>mapping sucessful<br/>");
	       request.getRequestDispatcher("./MappingOfClassTeacherSubject.jsp").include(request, response);
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
