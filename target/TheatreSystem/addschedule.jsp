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
   <div class = "container">
   <div class="card">
   <div class="card-body px-lg-5 pt-0">
       <h5 class="card-header info-color white-text text-center py-4">
           <strong>Add Schedule</strong>
       </h5>
   <form method="post" action="insertSchedule">
   <div class = "container">
     <div class="form-group">
      <label for="movieName">Choose a Movie:</label>
      <select name="movieName" id="movieName">
        <%
        try
            {
                 Context context = new InitialContext();
                 DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
                 Connection connection = dataSource.getConnection();
                String query = "Select * from movies";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while(result.next())
                {
                    %>
                        <option value="<%=result.getString("name")%>"><%=result.getString("name")%></option>
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

     <div class="form-group">
       <label for="InputStartTime" class="grey-text font-weight-light">Start Time</label>
       <input type="time" class="form-control" name="startTime" placeholder="Enter Start Time">
     </div>

     <div class="form-group">
       <label for="InputEndTime" class="grey-text font-weight-light">End Time</label>
       <input type="time" class="form-control" name="endTime" placeholder="Enter End Time">
     </div>

     <div class="form-group">
       <label for="InputDate" class="grey-text font-weight-light">Date</label>
       <input type="date" class="form-control" name="date" placeholder="Enter Date">
     </div>

     <div class="form-group">
      <label for="name">Choose a Room:</label>
      <select name="cinemaRoomName" id="cinemaRoomName">
        <%
        try
            {
                 Context context = new InitialContext();
                 DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
                 Connection connection = dataSource.getConnection();
                String query = "Select * from rooms";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while(result.next())
                {
                    %>
                        <option value="<%=result.getString("name")%>"><%=result.getString("name")%></option>
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
</body>
</html>
