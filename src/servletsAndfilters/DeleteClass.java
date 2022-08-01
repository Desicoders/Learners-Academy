package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pojoutil.ClassUtil;
import Pojoutil.StudentUtil;
import Pojoutil.SubjectUtil;
import Pojoutil.TeacherUtil;

/**
 * Servlet implementation class DeleteTeacher
 */
@WebServlet("/DeleteClass")
public class DeleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String ClassId=request.getParameter("classId");
		if(ClassId==null)
		{
			out.print("enter valid Class Id to Delete");
			request.getRequestDispatcher("./ViewAllClasses.jsp").include(request, response);
		}
		
		ClassUtil.deleteClassById(Integer.parseInt(ClassId));
		out.print("Class deleted");
		request.getRequestDispatcher("./ViewAllClasses.jsp").include(request, response);
		
	}

}
