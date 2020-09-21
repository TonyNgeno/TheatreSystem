package com.theatre.logic.interfaces;

import com.theatre.model.Message;
import com.theatre.model.Room;


import javax.ejb.Remote;

@Remote
public interface RoomLogicI {

    Room getRoomByName(String name);

    Message removeRoomByid(int id);

    Message addRoom(Room room);

}
