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
String description=request.getParameter("description");
try
{
Context context = new InitialContext();
DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
Connection connection = dataSource.getConnection();
Statement statement = connection.createStatement();
statement.executeUpdate("update movies set name = \""+name+"\", description = \""+description+"\" where id = "+id+";");
update movies set name = "Tony", description = "blah" where id = 4;
response.sendRedirect("movies.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
