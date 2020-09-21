package com.theatre.bean;

import com.theatre.model.Booking;

import java.util.List;

public interface BookingBeanI {
    String add(Booking booking);

    List<Booking> list();

    String delete(Booking booking);
}
