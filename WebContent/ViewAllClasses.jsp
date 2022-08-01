<%@page import="Pojoutil.ClassUtil"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
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
	<h1>View Classes</h1>
	<%
		List<Classes> li = ClassUtil.getAllClasses();
	%>
	<table border="5px" class="table">
		<thead>
			<td>Class id&nbsp;</td>
			<td>Class name&nbsp;</td>
		</thead>
		<%
			for (Classes c : li) {
		%>
		<tr>
			<td><%=c.getId()%></td>
			<td><%=c.getName()%></td>
			<td><a href=<%="./DeleteClass?classId=" + c.getId()%>>delete Class</a></td>
			
		</tr>
		<%
			}
		%>
	</table>
	<a href="./logout.jsp">logout</a>&nbsp;&nbsp;&nbsp;<a href="./Admin.jsp">back to Admin</a>

</body>
</html>