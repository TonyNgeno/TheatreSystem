package com.theatre.model;

import javax.persistence.*;

@Entity
@Table(name = "ticket_details")
public class Ticket extends BaseEntity {

    @Column
    private String serialNo;

    @OneToOne
    private Booking booking;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
