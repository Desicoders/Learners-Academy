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
	<h1>Mapping of Subjects and teacher with class</h1>
	<form action="./MappingServletMain">
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
		<br> <label for="teacherId">Choose a teacher</label> <select
			name="teacherId">
			<%
				List<Teacher> teacherList = TeacherUtil.getAllTeachers();
				for (Teacher teacher : teacherList) {
			%>

			<option value=<%=teacher.getId()%>><%="id = " + teacher.getId() + " :*: name=" + teacher.getName()%></option>
			<%
				}
			%>
		</select> <br>
		<br> <label for="subjectId">Choose a subject</label> <select
			name="subjectId">
			<%
				List<Subjects> SubjectList = SubjectUtil.getAllSubjects();
				for (Subjects subject : SubjectList) {
			%>

			<option value=<%=subject.getId()%>><%="id = " + subject.getId() + " :*: name=" + subject.getName()%></option>
			<%
				}
			%>
		</select> <br>
		<br> <input type="submit" value="Submit">
	</form>


	<a href="./logout.jsp">logout</a>&nbsp;&nbsp;&nbsp;<a href="./Admin.jsp">back to Admin</a>

</body>
</html>