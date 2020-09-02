package com.theatre.bean;

import com.theatre.annotation.NotSaveToDb;
import com.theatre.model.Room;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@NotSaveToDb
public class RoomBean2 implements RoomBeanI{


    public String add(Connection connection, Room room) {
        System.out.println("nothing will be added!!!");
        return "OK";
    }

    public List<Room> list(Connection connection) {
        List<Room> rooms = new ArrayList<Room>();
        Room room = new Room();
        room.setName("This is not from the database");
        room.setRoomNo("So no roomNo");
        rooms.add(room);

        room = new Room();
        room.setName("This is not from the database2");
        room.setRoomNo("So no roomNo2");
        rooms.add(room);

        return rooms;
    }
}
