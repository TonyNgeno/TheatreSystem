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
            PreparedStatement statement = connection.prepareStatement("insert into movieschedules(movieName, startTime, endTime, date, cinemaRoomName) values(?, ?, ?, ?, ?)");
            statement.setString(1, movieSchedule.getMovieName());
            statement.setString(2, movieSchedule.getStartTime());
            statement.setString(3, movieSchedule.getEndTime());
            statement.setString(4, movieSchedule.getDate());
            statement.setString(5, movieSchedule.getCinemaRoomName());

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
