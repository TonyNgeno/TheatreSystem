package com.theatre.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "movieschedules")
public class MovieSchedule extends BaseEntity {

    @Column
    private String movieName;

    @Column
    private String startTime;

    @Column
    private String endTime;

    @Column
    private String date;

    @Column
    private String cinemaRoomName;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

}
