package com.theatre.logic.interfaces;

import com.theatre.model.Message;
import com.theatre.model.MovieSchedule;
import com.theatre.model.Room;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface RoomLogicI {

    List<Room> getRoomByName(String name);

    Message removeRoomByid(int id);

    Message addRoom(Room room);


}
