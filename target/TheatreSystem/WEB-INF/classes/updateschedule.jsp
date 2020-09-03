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
<link rel="stylesheet" href="css/style.css">
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
                String query = "Select * from movieschedules where id ="+id;
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while(result.next())
                {

                %>
   <div class = "container">
   <div class="card">
   <div class="card-body px-lg-5 pt-0">
           <h5 class="card-header info-color white-text text-center py-4">
               <strong>Add Movie</strong>
           </h5>
       <form method="post" action="updatemovie-process.jsp">
        <input type="text" hidden=true class="form-control" name="id" value="<%=result.getString("id") %>">

         <div class="form-group">
           <label for="InputName" class="grey-text font-weight-light">Movie Name</label>
           <input type="text" class="form-control" name="movieName" value="<%=result.getString("movieName") %>" >
         </div>

         <div class="form-group">
           <label for="InputDescription" class="grey-text font-weight-light">Enter Description</label>
           <input type="text" class="form-control" name="description" value="<%=result.getString("description") %>">
         </div>

         <div class="form-group">
            <label for="Image" class="grey-text font-weight-light">Enter Image</label><br>
            <input type="file" name="photo" id="photo">
         </div><br><br>

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
