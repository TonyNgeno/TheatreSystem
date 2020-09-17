package com.theatre.model;

import javax.persistence.*;


@Entity
@Table(name = "movies")
public class Movie extends BaseEntity {
    @Column
    private String movieName;

    @Column
    private String description;

    @Column
    private String movieLength;

    @Column
    private String path;

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
}

