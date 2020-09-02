<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*, todo.db.*"%>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>
<%@page import="org.apache.commons.beanutils.BeanUtils" %>
<%@page import="com.theatre.model.MovieSchedule" %>
<%@page import="javax.inject.Inject" %>

<%
    String id=request.getParameter("id");
    MovieSchedule movieSchedule = new MovieSchedule();

try
{
Context context = new InitialContext();
DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
Connection connection = dataSource.getConnection();
String query = "Select * from movieschedules";
Statement statement = connection.createStatement();
int i=statement.executeUpdate("DELETE FROM movieschedules WHERE id="+id);
response.sendRedirect("movieschedule.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>