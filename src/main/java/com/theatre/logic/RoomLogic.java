package com.theatre.logic;

import com.theatre.logic.interfaces.RoomLogicI;
import com.theatre.logic.interfaces.UserLogicI;
import com.theatre.model.Message;
import com.theatre.model.Movie;
import com.theatre.model.MovieSchedule;
import com.theatre.model.Room;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote(RoomLogicI.class)
public class RoomLogic implements RoomLogicI {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Room> getRoomByName(String name) {
        try {
            Query query = entityManager.createNamedQuery("Room.findByName", Room.class);
            query.setParameter("name", name);
            return (List<Room>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Message removeRoomByid(int id) {
        entityManager.remove(entityManager.find(Room.class, id));
        return new Message(true, "Room is successfully deleted", id);
    }



    @Override
    public Message addRoom(Room room) {
        entityManager.merge(room);
        return new Message(true, "Room is successfully added", room);
    }

}
