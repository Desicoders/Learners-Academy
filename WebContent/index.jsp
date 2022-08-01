<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<hr />
	<hr />
	<h1>login</h1>
	
	  <form action="./controller" method="Get">
	  <input type="text" name="username" placeholder="Enter username"/><br/>
	  <input type="password" name="password" placeholder="Enter Password"/><br/>
	  <input type="hidden" value="admin" name="role"/><br/>
	  <button type="submit">login</button><br/>
	  </form>
	
	
	  
	<hr />
	<hr />

</body>
</html>