package com.theatre.bean;

import com.theatre.model.Movie;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieBean {
    public String add(Connection connection, Movie movie){
        if(connection == null || movie == null){
            return "Fail";
        }
        try {
            PreparedStatement statement = connection.prepareStatement("insert into movies(movieName, description, path) values(?, ?, ?)");
            statement.setString(1, movie.getMovieName());
            statement.setString(2, movie.getDescription());
            statement.setString(3, movie.getPath());
            statement.executeUpdate();

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return "OK";
    }

    public List<Movie> list(Connection connection) {
        List<Movie> movies = new ArrayList<Movie>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movies");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Movie movie = new Movie();
                movie.setMovieName(result.getString("movieName"));
                movie.setDescription(result.getString("description"));
                movie.setPath(result.getString("path"));

                movies.add(movie);
            }

        } catch (
                SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return movies;
    }
}
