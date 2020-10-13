<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.theatre.model.*" %>
<%@page import="javax.persistence.*" %>

<%
UserDetail userDetail = (UserDetail)session.getAttribute("userlogin");
if(userDetail == null){
    response.sendRedirect("frontend/sign-in.jsp");
    return;
}
%>
<!DOCTYPE html>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="bootstrap-4.5.2-dist/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="bootstrap-4.5.2-dist/css/simple-sidebar.css" rel="stylesheet">
    <title>50th Century Theatres</title>
</head>
<body>
<div class="d-flex" id="wrapper">
        <div class="bg-light border-right" id="sidebar-wrapper">
            <div class="sidebar-heading"><b>50th Century Theatres</b></div>
            <div class="sidebar-heading"><b>Welcome <%=userDetail.getUsername()%></b></div>
            <div class="list-group list-group-flush">
                <a href="./index.jsp" class="list-group-item list-group-item-action bg-light">Dashboard</a>
                <a href="booking.jsp" class="list-group-item list-group-item-action bg-light">Bookings</a>
                <a href="./movies.jsp" class="list-group-item list-group-item-action bg-light">Movies</a>
                <a href="./movieschedule.jsp" class="list-group-item list-group-item-action bg-light">Schedules</a>
                <a href="./cinemarooms.jsp" class="list-group-item list-group-item-action bg-light">Cinema Rooms</a>
                <a href="logoutServlet" class="list-group-item list-group-item-action bg-light">Logout</a>
            </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>

</body>
</html>