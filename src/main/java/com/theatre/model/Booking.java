package com.theatre.model;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {

    @Column
    private String username;

    @Column
    private String phoneNo;

    @Column
    private String movieName;

    @Column
    private String cinemaRoomName;

    @Column
    private String childrenNo;

    @Column
    private String adultNo;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCinemaRoomName() {
        return cinemaRoomName;
    }

    public void setCinemaRoomName(String cinemaRoomName) {
        this.cinemaRoomName = cinemaRoomName;
    }

    public String getChildrenNo() {
        return childrenNo;
    }

    public void setChildrenNo(String childrenNo) {
        this.childrenNo = childrenNo;
    }

    public String getAdultNo() {
        return adultNo;
    }

    public void setAdultNo(String adultNo) {
        this.adultNo = adultNo;
    }
}
