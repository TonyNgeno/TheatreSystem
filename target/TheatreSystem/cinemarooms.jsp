<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.theatre.utilities.*" %>
<%@page import="com.theatre.*" %>
<%@page import="com.theatre.servlet.*" %>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>

<html>

<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Rooms</title>
</head>
<body>
 <%@ include file="./page/navbar.jsp" %><br>
 <div class="container-lg">
     <div class="table-responsive">
         <div class="table-wrapper">
             <div class="table-title">
	<table class = "table table-bordered table-stripped table-condensed" align = "center">
		<tr>
		    <thead>
                <th scope="col">No</th>
                <th scope="col">Room Name</th>
                <th scope="col">No of Seats</th>
                <th scope="col">Action</th>
            </thead>
		</tr><br>
		             <a href="addroom.jsp"><button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New Room</button></a><br><br>

            <%
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
            try
            {
                Connection connection = dataSource.getConnection();
                String query = "Select * from rooms";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                int count = 0;
                while(result.next())
                {
                count += 1;
                %>

                <tr>
                <td><%=count%></td>
                <td><%=result.getString("name")%></td>
                <td><%=result.getString("noOfSeats")%></td>
                <td>
                     <a href="updaterooms.jsp?id=<%=result.getString("id") %>" class="edit" title="Edit" data-toggle="tooltip"><button class="btn btn-success btn-sm rounded-0" href="updaterooms.jsp?id=<%=result.getString("id") %>"  type="button" data-toggle="tooltip" data-placement="top" title="Edit"><i class="fa fa-edit"></i></button></a>
                     <a href="deleterooms.jsp?id=<%=result.getString("id") %>"onclick="return confirm('Are you sure you want to delete?')"  class="delete" title="Delete" data-toggle="tooltip"><button class="btn btn-danger btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Delete"><i class="fa fa-trash"></i></button></a>
                </td>

                </tr>
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
	</table>
    </div>
        </div>
            </div>
                </div>
</body>
</html>



































































































