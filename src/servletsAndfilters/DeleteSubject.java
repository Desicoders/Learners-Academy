package servletsAndfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pojoutil.StudentUtil;
import Pojoutil.SubjectUtil;
import Pojoutil.TeacherUtil;

/**
 * Servlet implementation class DeleteTeacher
 */
@WebServlet("/DeleteSubject")
public class DeleteSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSubject() {
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
		String SubjectId=request.getParameter("subjectId");
		if(SubjectId==null)
		{
			out.print("enter valid Subject Id to Delete");
			request.getRequestDispatcher("./ViewAllSubjects.jsp").include(request, response);
		}
		
		SubjectUtil.deleteSubjectById(Integer.parseInt(SubjectId));
		out.print("Subject deleted");
		request.getRequestDispatcher("./ViewAllSubjects.jsp").include(request, response);
		
	}

}
