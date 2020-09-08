package com.theatre.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theatre.bean.MovieScheduleBean;
import com.theatre.bean.MovieScheduleBeanI;
import com.theatre.bean.RoomBeanI;
import com.theatre.model.MovieSchedule;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
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

    @EJB
    private MovieScheduleBeanI movieScheduleBean;

    @Inject
    private MovieSchedule movieSchedule ;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(movieScheduleBean.list()));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            BeanUtils.populate(movieSchedule, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.getWriter().print(movieScheduleBean.add(movieSchedule));
        response.sendRedirect("movieschedule.jsp");
    }

}
