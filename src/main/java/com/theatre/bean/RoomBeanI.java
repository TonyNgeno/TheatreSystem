package com.theatre.bean;

import com.theatre.model.Room;

import java.util.List;

public interface RoomBeanI {

    String add(Room room);

    List<Room> list();

    String delete(Room room);



}

