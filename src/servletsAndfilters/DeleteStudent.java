package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pojoutil.StudentUtil;
import Pojoutil.TeacherUtil;

/**
 * Servlet implementation class DeleteTeacher
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
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
		String Studentid=request.getParameter("studentId");
		if(Studentid==null)
		{
			out.print("enter valid Student Id to Delete");
			request.getRequestDispatcher("./ViewAllStudents.jsp").include(request, response);
		}
		
		StudentUtil.deleteStudentById(Integer.parseInt(Studentid));
		out.print("Student deleted");
		request.getRequestDispatcher("./ViewAllStudents.jsp").include(request, response);
		
	}

}
