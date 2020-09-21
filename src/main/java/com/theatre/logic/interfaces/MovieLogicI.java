package com.theatre.logic.interfaces;

import com.theatre.model.Message;
import com.theatre.model.Movie;

import javax.ejb.Remote;

@Remote
public interface MovieLogicI {

    Movie getMovieByName(String name);

    Message removeMovieByid(int id);

    Message addMovie(Movie movie);

}
