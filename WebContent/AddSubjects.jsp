<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add subjects</h1>
	<form action="./addSubject">
		<input type="text" name="name" placeholder="Enter Subject name" />
		<button type="submit">add subject</button>
	</form>
	<a href="./logout.jsp">logout</a>&nbsp;&nbsp;&nbsp;
	<a href="./Admin.jsp">back to Admin</a>

</body>
</html>