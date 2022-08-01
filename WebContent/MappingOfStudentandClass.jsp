<%@page import="Pojoutil.StudentUtil"%>
<%@page import="Pojoutil.SubjectUtil"%>
<%@page import="pojos.Subjects"%>
<%@page import="Pojoutil.TeacherUtil"%>
<%@page import="pojos.Teacher"%>
<%@page import="pojos.Student"%>
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
</head>
<body>
	<h1>Mapping of students with class</h1>
	<form action="./MappingServletSub">
		<label for="classId">Choose a class</label> <select name="classId">
			<%
				List<Classes> classList = ClassUtil.getAllClasses();
				for (Classes clazz : classList) {
			%>

			<option value=<%=clazz.getId()%>><%="id = " + clazz.getId() + " :*: name=" + clazz.getName()%></option>
			<%
				}
			%>
		</select> <br>
		<br> <label for="studentId">Choose a Student</label> <select
			name="studentId">
			<%
				List<Student> studentsList = StudentUtil.getAllStudents();
				for (Student student : studentsList) {
			%>

			<option value=<%=student.getId()%>><%="id = " + student.getId() + " :*: name=" + student.getName()%></option>
			<%
				}
			%>
		</select> <br>
		<br> <input type="submit" value="Submit">
	</form>


	<a href="./logout.jsp">logout</a>&nbsp;&nbsp;&nbsp;<a href="./Admin.jsp">back to Admin</a>

</body>
</html>