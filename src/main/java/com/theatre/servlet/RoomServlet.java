package com.theatre.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theatre.bean.RoomBeanI;
import com.theatre.model.Room;
import com.theatre.ws.rest.RoomRestApi;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/rooms")
public class RoomServlet extends HttpServlet {

    @EJB
    private RoomBeanI roomBean;

    @Inject
    private Room room ;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(roomBean.list()));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            BeanUtils.populate(room, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.getWriter().print(roomBean.add(room));
        response.sendRedirect("cinemarooms.jsp");
    }


}
