package com.theatre.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theatre.bean.MovieBean;
import com.theatre.model.Movie;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

@WebServlet("/addMovie")
public class MovieServlet extends HttpServlet {

    @Inject
    private MovieBean movieBean;

    @Inject
    private Movie movie ;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
        resp.setContentType("text/plain");

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(movieBean.list(dbConnection)));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");

        try {
            BeanUtils.populate(movie, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.getWriter().print(movieBean.add(dbConnection, movie));
        response.sendRedirect("movies.jsp");
    }
}
