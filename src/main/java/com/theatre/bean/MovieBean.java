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
            PreparedStatement statement = connection.prepareStatement("insert into movies(id, name, description) values(?, ?, ?)");
            statement.setInt(1, movie.getId());
            statement.setString(2, movie.getName());
            statement.setString(3, movie.getDescription());
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
                movie.setId(result.getInt("id"));
                movie.setName(result.getString("name"));
                movie.setDescription(result.getString("description"));

                movies.add(movie);
            }

        } catch (
                SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return movies;
    }
}
