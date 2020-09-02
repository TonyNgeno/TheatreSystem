package com.theatre.bean;

import com.theatre.model.Movie;
import com.theatre.model.MovieSchedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieScheduleBean implements MovieScheduleBeanI{
    public String add(Connection connection, MovieSchedule movieSchedule){
        if(connection == null || movieSchedule == null){
            return "Fail";
        }
        try {
            PreparedStatement statement = connection.prepareStatement("insert into movieschedules(id, movieName, startTime, endTime, date, cinemaRoomName) values(?, ?, ?, ?, ?, ?)");
            statement.setInt(1, movieSchedule.getId());
            statement.setString(2, movieSchedule.getMovieName());
            statement.setString(3, movieSchedule.getStartTime());
            statement.setString(4, movieSchedule.getEndTime());
            statement.setString(5, movieSchedule.getDate());
            statement.setString(6, movieSchedule.getCinemaRoomName());

            statement.executeUpdate();

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return "OK";
    }

    public List<MovieSchedule> list(Connection connection) {
        List<MovieSchedule> movieSchedules = new ArrayList<MovieSchedule>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movieschedules");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                MovieSchedule movieSchedule = new MovieSchedule();
                movieSchedule.setId(result.getInt("id"));
                movieSchedule.setMovieName(result.getString("movieName"));
                movieSchedule.setStartTime(result.getString("startTime"));
                movieSchedule.setEndTime(result.getString("endTime"));
                movieSchedule.setDate(result.getString("date"));
                movieSchedule.setCinemaRoomName(result.getString("cinemaRoomName"));

                movieSchedules.add(movieSchedule);
            }

        } catch (
                SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return movieSchedules;
    }
}
