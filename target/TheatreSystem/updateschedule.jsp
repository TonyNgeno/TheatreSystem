<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.theatre.utilities.*" %>
<%@page import="com.theatre.*" %>
<%@page import="com.theatre.servlet.*" %>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
 <%@ include file="./page/navbar.jsp" %><br>
 <%
             String id=request.getParameter("id");
             try
             {
                Context context = new InitialContext();
                DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
                Connection connection = dataSource.getConnection();
                 String query1 = "Select * from movieschedules where id ="+id;
                 Statement statement1 = connection.createStatement();
                 ResultSet result1 = statement1.executeQuery(query1);
                 while(result1.next())
                 {

                 %>

   <div class = "container">
   <div class="card">
   <div class="card-body px-lg-5 pt-0">
       <h5 class="card-header info-color white-text text-center py-4">
           <strong>Update Schedule</strong>
       </h5>
   <form method="post" action="updateschedule-process.jsp">
   <div class = "container">
     <div class="form-group">
      <label for="movieName">Choose a Movie:</label>
      <select name="movieName" id="movieName">
        <%
        try
            {

                String query2 = "Select * from movies";
                Statement statement2 = connection.createStatement();
                ResultSet result2 = statement2.executeQuery(query2);
                while(result2.next())
                {
                    %>
                        <option value="<%=result2.getString("movieName")%>"><%=result2.getString("movieName")%></option>
                    <%

                }
                }
        catch(Exception ex)
            {
                out.println("Exception:" +ex.getMessage());
                ex.printStackTrace();
            }
        %>
      </select>
     </div>

     <input type="text" hidden=true class="form-control" name="id" value="<%=result1.getString("id") %>">

     <div class="form-group">
       <label for="InputStartTime" class="grey-text font-weight-light">Start Time</label>
       <input type="time" class="form-control" name="startTime" value = "<%=result1.getString("startTime")%>">
     </div>

     <div class="form-group">
       <label for="InputEndTime" class="grey-text font-weight-light">End Time</label>
       <input type="time" class="form-control" name="endTime" value = "<%=result1.getString("endTime")%>">
     </div>

     <div class="form-group">
       <label for="InputDate" class="grey-text font-weight-light">Date</label>
       <input type="date" class="form-control" name="date" value = "<%=result1.getString("date")%>">
     </div>

     <div class="form-group">
      <label for="name">Choose a Room:</label>
      <select name="cinemaRoomName" id="cinemaRoomName">
        <%
        try
            {

                String query3 = "Select * from rooms";
                Statement statement3 = connection.createStatement();
                ResultSet result3 = statement3.executeQuery(query3);
                while(result3.next())
                {
                    %>
                        <option value="<%=result3.getString("name")%>"><%=result3.getString("name")%></option>
                    <%

                }
                }
        catch(Exception ex)
            {
                out.println("Exception:" +ex.getMessage());
                ex.printStackTrace();
            }
        %>
      </select>
     </div>





     <button type="submit" class="btn btn-primary">Submit</button>

   </form>
   </div>
   </div>
   </div>
     <%

                           }
                       }
                       catch(Exception ex)
                       {
                           out.println("Exception:" +ex.getMessage());
                           ex.printStackTrace();
                       }

         %>
</body>
</html>
