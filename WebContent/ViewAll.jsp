<%@page import="pojos.TeachesAndSubject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="Pojoutil.StudentUtil"%>
<%@page import="pojos.Student"%>
<%@page import="pojos.Subjects"%>
<%@page import="pojos.Teacher"%>
<%@page import="Pojoutil.ClassUtil"%>
<%@page import="pojos.Classes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>View all Master table along with relations</h1>
	<%
		List<Classes> classList = ClassUtil.getAllClasses();
		for (Classes clazz : classList) {
	%>

	<table border="5px" class="table">
		<tr>
			<th>class id and name</th>
			<th>teacher id and name</th>
			<th>subject id and name</th>
			<th>student id and name</th>
		</tr>
		<%int max=0;
		Set<TeachesAndSubject> teachesAndSubjects=clazz.getTeachesAndSubject();
		
		List<Student> studentList=StudentUtil.getStudentsbyClass(clazz);
		int studetLength=studentList.size();
		max=Math.max(teachesAndSubjects.size(),studetLength);
		%>
		
		<tr>
		<td rowspan=<%=max%>> <%=clazz.getId()+" :: "+clazz.getName()%>  </td>
		
		
		<td>
		<ul>
		<%for(TeachesAndSubject tAndS:teachesAndSubjects){ %>		
		<li><%=tAndS.getTeach().getId()+" :: "+tAndS.getTeach().getName()%></li>		
		<%} %>
		</ul>
		</td>
		<td>
		<ul>
		<%for(TeachesAndSubject tAndS:teachesAndSubjects){ %>		
		<li><%=tAndS.getSubject().getId()+" :: "+tAndS.getSubject().getName() %></li>		
		<%} %>
		</ul>
		</td>
		<td>
		<ul>
		<%for(Student student:studentList){ %>		
		<li><%=student.getId()+" :: "+student.getName() %></li>		
		<%} %>
		</ul>
		
		</td>
		</tr>
		
	</table>

	<%
		}
	%>
	<a href="./logout.jsp">logout</a>&nbsp;&nbsp;&nbsp;
	<a href="./Admin.jsp">back to Admin</a>
</body>
</html>