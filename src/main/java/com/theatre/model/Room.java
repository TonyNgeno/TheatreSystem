package com.theatre.model;

import javax.persistence.*;
import java.sql.Blob;


@Entity
@Table(name = "rooms")
/*@NamedQueries({
        @NamedQuery(name = "Room.deleteRoomById", query = "delete r FROM Room r where r.id = :id"),
        @NamedQuery(name = "Room.findByName", query = "SELECT r FROM Room r WHERE r.name = :name"),})*/
@NamedQueries({
        @NamedQuery(name = "Room.deleteRoomById", query = "delete FROM Room r where r.id = :id"),
        @NamedQuery(name = "Room.findRoomByid", query = "SELECT r FROM Room r WHERE r.id = :id"),
        @NamedQuery(name = "Room.findByName", query = "SELECT r FROM Room r WHERE r.name = :name"),})
public class Room extends BaseEntity {


    @Column
    private String name;

    @Column
    private String noOfSeats;

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
