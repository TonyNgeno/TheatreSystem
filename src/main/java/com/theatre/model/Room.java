package com.theatre.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@NamedQuery(name = "Room.findAll", query = "From Room r")
@Entity
@Table(name = "rooms")
public class Room extends BaseEntity {


    @Column
    private String name;

    @Column
    private String noOfSeats;

    private Seats seats;

    @Column
    private Blob roomPic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(String noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

}
