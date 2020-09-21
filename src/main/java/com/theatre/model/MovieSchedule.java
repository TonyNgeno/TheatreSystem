package com.theatre.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "movieschedules")
@NamedQueries({
        @NamedQuery(name = "MovieSchedule.findAll", query = "SELECT ms FROM MovieSchedule ms"),
        @NamedQuery(name = "MovieSchedule.findAllSchedulesOrdered", query = "SELECT ms FROM MovieSchedule ms ORDER BY ms.startTime DESC"),
        @NamedQuery(name = "MovieSchedule.findByMovieName", query = "SELECT ms FROM MovieSchedule ms WHERE ms.movieName = :movieName"),
        @NamedQuery(name = "MovieSchedule.findByStartTime", query = "SELECT ms FROM MovieSchedule ms WHERE ms.startTime = :startTime"),
        @NamedQuery(name = "MovieSchedule.findByEndTime", query = "SELECT ms FROM MovieSchedule ms WHERE ms.endTime = :endTime"),
        @NamedQuery(name = "MovieSchedule.findByCinemaRoomName", query = "SELECT ms FROM MovieSchedule ms WHERE ms.cinemaRoomName = :cinemaRoomName"),
        @NamedQuery(name = "MovieSchedule.findByDate", query = "SELECT ms FROM MovieSchedule ms WHERE ms.date = :date"),})
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

    @ManyToOne
    private Movie movie;

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
