<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.theatre.utilities.*" %>
<%@page import="com.theatre.*" %>
<%@page import="com.theatre.servlet.*" %>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>

<%

String id=request.getParameter("id");
String name=request.getParameter("name");
String noOfSeats=request.getParameter("noOfSeats");
try
{
Context context = new InitialContext();
DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
Connection connection = dataSource.getConnection();
Statement statement = connection.createStatement();
statement.executeUpdate("update rooms set name = \""+name+"\", noOfSeats = \""+noOfSeats+"\" where id = "+id+";");
response.sendRedirect("cinemarooms.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
