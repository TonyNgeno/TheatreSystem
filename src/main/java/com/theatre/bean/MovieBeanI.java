package com.theatre.bean;

import com.theatre.model.Movie;
import com.theatre.model.Room;

import java.sql.Connection;
import java.util.List;

public interface MovieBeanI {
    String add(Connection connection, Movie movie);

    List<Room> list(Connection connection);
}
