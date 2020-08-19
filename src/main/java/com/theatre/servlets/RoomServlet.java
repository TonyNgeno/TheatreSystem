package com.theatre.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theatre.model.Room;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/rooms")
public class RoomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
        resp.setContentType("text/plain");

        List<Room> rooms = new ArrayList<Room>();

        try {
            PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM rooms");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()){
               Room room = new Room();
               room.setName(result.getString("name"));
               room.setRoomNo(result.getString("roomNo"));

               rooms.add(room);
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(rooms));
    }
}
