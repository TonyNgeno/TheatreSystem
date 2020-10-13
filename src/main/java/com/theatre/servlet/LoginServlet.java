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
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

            /*    response.sendRedirect("index.jsp");*/

                if (userDetails.getRole().equals("Admin")){
                    response.sendRedirect("index.jsp");
                }
                else if (userDetails.getRole().equals("Customer")){
                    response.sendRedirect("frontend/index.jsp");
                }
                else {
                    response.sendRedirect("frontend/sign-in.jsp");
                }


            }
            else {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User or password incorrect');");
                out.println("location='frontend/sign-in.jsp';");
                out.println("</script>");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /*response.sendRedirect("frontend/sign-in.jsp");*/
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}