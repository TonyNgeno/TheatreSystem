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
String startTime=request.getParameter("startTime");
String endTime=request.getParameter("endTime");
String date=request.getParameter("date");
String cinemaRoomName=request.getParameter("cinemaRoomName");

try
{
Context context = new InitialContext();
DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
Connection connection = dataSource.getConnection();
Statement statement = connection.createStatement();
statement.executeUpdate("update movieschedules set movieName = \""+movieName+"\", startTime = \""+startTime+"\", endTime = \""+endTime+"\" , date = \""+date+"\", cinemaRoomName = \""+cinemaRoomName+"\"   where id = "+id+";");
response.sendRedirect("movieschedule.jsp");
connection.close();
}

catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
