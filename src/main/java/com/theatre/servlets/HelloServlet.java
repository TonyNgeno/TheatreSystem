package com.theatre.servlets;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tony")
public class HelloServlet extends HttpServlet{


/*    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        PrintWriter printWriter = servletResponse.getWriter();

        printWriter.println("This is generated using generic servlet");

    }*/

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name= request.getParameter("name");
        String age= request.getParameter("age");
        String city= request.getParameter("city");
        
        Integer ageInt = Integer.valueOf(age);
        StringBuilder msg = new StringBuilder();

        msg.append("Hi" +name + ",from," +city + "." );

        if (ageInt >20)
            msg.append("You should have girlfriend");
        else
            msg.append("No one allowed");

        PrintWriter printWriter = response.getWriter();
        printWriter.println(msg);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        PrintWriter printWriter = response.getWriter();

        printWriter.println("This is my first servlet");
    }



}
