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
String movieName=request.getParameter("movieName");
String description=request.getParameter("description");
try
{
Context context = new InitialContext();
DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
Connection connection = dataSource.getConnection();
Statement statement = connection.createStatement();
System.out.println("id:"+id);
System.out.println("name:" +movieName);
System.out.println("description:" +description);
statement.executeUpdate("update movies set movieName = \""+movieName+"\", description = \""+description+"\" where id = "+id+";");
response.sendRedirect("./movies.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
