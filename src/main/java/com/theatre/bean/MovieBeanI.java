package com.theatre.bean;

import com.theatre.model.Movie;

import java.util.List;

public interface MovieBeanI {

    String add(Movie movie);

    List<Movie> list();
}
