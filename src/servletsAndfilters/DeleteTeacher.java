package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pojoutil.TeacherUtil;

/**
 * Servlet implementation class DeleteTeacher
 */
@WebServlet("/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeacher() {
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
		String Tid=request.getParameter("teacherId");
		if(Tid==null)
		{
			out.print("enter valid Teacher Id to Delete");
			request.getRequestDispatcher("./ViewAllTeachers.jsp").include(request, response);
		}
		
		TeacherUtil.deleteTeacherById(Integer.parseInt(Tid));
		out.print("Teacher deleted");
		request.getRequestDispatcher("./ViewAllTeachers.jsp").include(request, response);
		
	}

}
