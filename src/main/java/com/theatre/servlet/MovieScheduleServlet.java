package com.theatre.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theatre.bean.MovieScheduleBean;
import com.theatre.model.MovieSchedule;
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

@WebServlet("/insertSchedule")
public class MovieScheduleServlet extends HttpServlet {
    @Inject
    private MovieScheduleBean movieScheduleBean;

    @Inject
    private MovieSchedule movieSchedule ;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
        resp.setContentType("text/plain");

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(movieScheduleBean.list(dbConnection)));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");

        try {
            BeanUtils.populate(movieSchedule, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.getWriter().print(movieScheduleBean.add(dbConnection, movieSchedule));
        response.sendRedirect("movieschedule.jsp");
    }

}
