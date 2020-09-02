<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*, todo.db.*"%>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>
<%@page import="org.apache.commons.beanutils.BeanUtils" %>
<%@page import="com.theatre.model.Room" %>
<%@page import="javax.inject.Inject" %>

<%
    String id=request.getParameter("id");
    Room room = new Room();

BeanUtils.populate(room, request.getParameterMap());
try
{
Context context = new InitialContext();
DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
Connection connection = dataSource.getConnection();
String query = "Select * from rooms";
Statement statement = connection.createStatement();
int i=statement.executeUpdate("DELETE FROM rooms WHERE id="+id);
response.sendRedirect("cinemarooms.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
