<%@page import="Hibernateutil.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%session.invalidate();
    HibernateUtil hu=new HibernateUtil();
    Session s=hu.getSessionFactory();
    s.close();
    hu.closeSessionFactory();
    
    %>
    <h1>logout sucess</h1>
    <h3><a href="./">back to login</a></h3>
</body>
</html>