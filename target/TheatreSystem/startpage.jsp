<%@ page import="com.theatre.model.UserDetail" %>

<%
    UserDetail user = (UserDetail) session.getAttribute("userlogin");
    if(user ==null){
        response.sendRedirect("frontend/sign-in.jsp");
    }//redirect based on user roles
    else {
        if(user.getRole().equals("Admin")){
            response.sendRedirect("index.jsp");
        }
        else if(user.getRole().equals("User")){
            response.sendRedirect("frontend/index.jsp");
        }
        else {
            response.sendRedirect(request.getContextPath());
        }
    }
%>