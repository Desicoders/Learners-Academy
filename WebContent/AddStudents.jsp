<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Students</h1>
	<form action="./addStudent">
		<input type="text" name="name" placeholder="Enter Student name" />
		<button type="submit">add Student</button>
	</form>
	<a href="./logout.jsp">logout</a>&nbsp;&nbsp;&nbsp;
	<a href="./Admin.jsp">back to Admin</a>

</body>
</html>