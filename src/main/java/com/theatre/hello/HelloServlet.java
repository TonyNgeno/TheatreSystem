package com.theatre.hello;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tony")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter printWriter = response.getWriter();

        printWriter.println("This is my first servlet");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        PrintWriter printWriter = response.getWriter();

        printWriter.println("This is my first servlet");
    }


}
