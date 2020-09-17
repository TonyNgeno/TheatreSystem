package com.theatre.model;

import com.theatre.bean.Contact;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {

    @Column
    private String name;

    @OneToOne
    private Ticket ticket;

    @Embedded
    private Contact contact;


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
