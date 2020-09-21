package com.theatre.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "movies")
@NamedQueries({
        @NamedQuery(name = "Movie.findByName", query = "SELECT m FROM Movie m WHERE m.movieName = :movieName"),})
public class Movie extends BaseEntity {


    @Column
    private String movieName;

    @Column
    private String description;

    @Column
    private String movieLength;

    @Column
    private String path;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieSchedule> movieSchedules = new ArrayList<MovieSchedule>();

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    @XmlTransient
    @JsonIgnore
    public List<MovieSchedule> getMovieSchedules() {
        return movieSchedules;
    }

    public void setMovieSchedules(List<MovieSchedule> movieSchedules) {
        this.movieSchedules = movieSchedules;
    }
}

