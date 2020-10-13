package com.theatre.logic.interfaces;

import com.theatre.model.Message;
import com.theatre.model.Movie;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface MovieLogicI {

    List<Movie> getMovieByName(String name);

    Message removeMovieByid(int id);

    Message addMovie(Movie movie);

}
