package com.theatre.bean;

import com.theatre.model.Room;

import java.sql.Connection;
import java.util.List;

public interface RoomBeanI {

    String add(Connection connection, Room room);

    List<Room> list(Connection connection);

}

