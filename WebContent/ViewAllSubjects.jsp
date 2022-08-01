<%@page import="Pojoutil.SubjectUtil"%>
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
	<h1>View Subjects</h1>
	<%
		List<Subjects> li = SubjectUtil.getAllSubjects();
	%>
	<table border="5px" class="table">
		<thead>
			<td>Subject id&nbsp;</td>
			<td>Subject name&nbsp;</td>
		</thead>
		<%
			for (Subjects s : li) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>

		</tr>
		<%
			}
		%>
	</table>
	<a href="./logout.jsp">logout</a>&nbsp;&nbsp;&nbsp;
	<a href="./Admin.jsp">back to Admin</a>

</body>
</html>