package com.theatre.bean;

import com.theatre.annotation.NotSaveToDb;
import com.theatre.annotation.SaveToDb;
import com.theatre.model.Room;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RoomBean implements RoomBeanI {

    public String add(Connection connection, Room room){

        if(connection == null || room == null){
            return "Fail";
        }
        try {
            PreparedStatement statement = connection.prepareStatement("insert into rooms(name, noOfSeats) values(?, ?)");
            statement.setString(1, room.getName());
            statement.setString(2, room.getNoOfSeats());
            statement.executeUpdate();


        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return "OK";
    }

    public List<Room> list(Connection connection) {
        List<Room> rooms = new ArrayList<Room>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rooms");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Room room = new Room();
                room.setName(result.getString("name"));
                room.setNoOfSeats(result.getString("noOfSeats"));

                rooms.add(room);
            }

        } catch (
                SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
       return rooms;
    }
}
