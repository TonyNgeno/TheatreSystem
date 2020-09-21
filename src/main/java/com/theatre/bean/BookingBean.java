package com.theatre.bean;

import com.theatre.model.Booking;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class BookingBean implements BookingBeanI {

    @Inject
    private Booking booking;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String add(Booking booking) {

        entityManager.merge(booking);
        return "Ok";

    }

    @Override
    public List<Booking> list() {
        return entityManager.createQuery("From Booking b").getResultList();
    }

    @Override
    public String delete(Booking booking) {

        entityManager.remove(booking);
        return "OK";

    }
}
