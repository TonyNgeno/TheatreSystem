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
                String query = "Select * from rooms where id ="+id;
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while(result.next())
                {

                %>
   <div class = "container">
   <div class="card">
   <div class="card-body px-lg-5 pt-0">
       <h5 class="card-header info-color white-text text-center py-4">
           <strong>Update Room</strong>
       </h5>
   <form method="post" action="updaterooms-process.jsp">
     <input type="text" hidden=true class="form-control" name="id" value="<%=result.getString("id") %>">
     <div class="form-group">
       <label for="InputName" class="grey-text font-weight-light">Room Name</label>
       <input type="text" class="form-control" name="name" value="<%=result.getString("name") %>">
     </div>

     <div class="form-group">
       <label for="InputSeats" class="grey-text font-weight-light">No of Seats Available</label>
       <input type="text" class="form-control" name="noOfSeats" value="<%=result.getString("noOfSeats") %>">
     </div>
     <button type="submit" class="btn btn-primary">Submit</button>
   </form>

   </div>
    </div>
     </div>
      <%

                        }
                        connection.close();
                    }

                    catch(Exception ex)
                    {
                        out.println("Exception:" +ex.getMessage());
                        ex.printStackTrace();
                    }

      %>
</body>
</html>
