package com.theatre.bean;

import com.theatre.model.Room;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
@Remote
public class RoomBean implements RoomBeanI {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String add(Room room){
        em.merge(room);

        return "ok";

    }

    public List<Room> list() {
       return em.createQuery("From Room o").getResultList();

    }



    @Override
    public String delete(Room room) {
        em.remove(room);

        return "ok";
    }

}
