package com.theatre.servlet;

import com.theatre.logic.interfaces.UserLogicI;
import com.theatre.model.Message;
import com.theatre.model.UserDetail;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserDetail userDetail;

    @EJB
    private UserLogicI userLogic;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BeanUtils.populate(userDetail, request.getParameterMap());

            UserDetail userDetails = userLogic.getUser(userDetail);

            if(userDetails != null){

                HttpSession httpSession = request.getSession();

                httpSession.setAttribute("userlogin", userDetails);

                response.sendRedirect("index.jsp");

      /*      new Message(false, "Failed Please enter details");
*/
                return;
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
