<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*, todo.db.*"%>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>
<%@page import="org.apache.commons.beanutils.BeanUtils" %>
<%@page import="com.theatre.model.Movie" %>
<%@page import="javax.inject.Inject" %>

<%
    String id=request.getParameter("id");
    Movie movie = new Movie();

BeanUtils.populate(movie, request.getParameterMap());
try
{
Context context = new InitialContext();
DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
Connection connection = dataSource.getConnection();
String query = "Select * from movies";
Statement statement = connection.createStatement();
int i=statement.executeUpdate("DELETE FROM movies WHERE id=" +id);
response.sendRedirect("movies.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>