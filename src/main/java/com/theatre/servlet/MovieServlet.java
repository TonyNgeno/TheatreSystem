package com.theatre.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theatre.bean.MovieBean;
import com.theatre.bean.MovieBeanI;
import com.theatre.bean.RoomBeanI;
import com.theatre.model.Movie;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/addMovie")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000)
public class MovieServlet extends HttpServlet {

    private static final String SAVE_DIR = "img";
    @EJB
    private MovieBeanI movieBean;

    @Inject
    private Movie movie ;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(movieBean.list()));

    }

    private String extractFileName(Part part) {
        String contentDis = part.getHeader("content-disposition");
        String[] items = contentDis.split(";");
        for (String s: items){
            if (s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out  = response.getWriter();

        String savePath = "/home/coderiot/Desktop/Systech/Leearning/TheatreSystem/src/main/webapp" + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);

        Part part = request.getPart("path");
        String fileName = extractFileName(part);

        part.write(savePath + File.separator + fileName);

        try {
            BeanUtils.populate(movie, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.getWriter().print(movieBean.add(movie));

        response.sendRedirect("movies.jsp");
    }
}