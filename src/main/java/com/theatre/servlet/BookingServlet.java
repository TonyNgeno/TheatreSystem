package com.theatre.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.theatre.bean.BookingBeanI;
import com.theatre.model.Booking;
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

@WebServlet("/bookings")
public class BookingServlet extends HttpServlet {

    @EJB
    private BookingBeanI bookingBean;

    @Inject
    private Booking booking ;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(bookingBean.list()));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            BeanUtils.populate(booking, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.getWriter().print(bookingBean.add(booking));
        response.sendRedirect("booking.jsp");
    }
}
