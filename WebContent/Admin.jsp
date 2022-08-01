<%@page import="pojos.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome admin</h1><hr>
	<h2>Subjects</h2>
	<h3><a href="./AddSubjects.jsp"> add Subjects</a> &nbsp;&nbsp;&nbsp;<a href="./ViewAllSubjects.jsp">view Subjects</a></h3>
    <h2>Teacher</h2>
	<h3><a href="./AddTeachers.jsp">add Teacher </a>&nbsp;&nbsp;&nbsp;<a href="./ViewAllTeachers.jsp">view Teacher</a></h3>	
	<h2>Classes</h2>
	<h3><a href="./AddClasses.jsp">add Classes </a>&nbsp;&nbsp;&nbsp;<a href="./ViewAllClasses.jsp">view Classes</a></h3>	
	<h2>Students</h2>
	<h3><a href="./AddStudents.jsp">add Student</a> &nbsp;&nbsp;&nbsp;<a href="./ViewAllStudents.jsp">view Students</a></h3>
	<h2>Mapping</h2>
	<h3><a href="./MappingOfStudentandClass.jsp">Map class and Student</a>&nbsp;&nbsp;&nbsp;<a href="./MappingOfClassTeacherSubject.jsp">Map Teacher,Classes and Subjects</a></h3>
	
	<h2><a href="./ViewAll.jsp">View all Relationships and entities</a></h2>
		
		
		
		<a href="./logout.jsp">logout</a>
</body>
</html>
