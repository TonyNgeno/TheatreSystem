package com.theatre.logic.interfaces;

import com.theatre.model.Message;
import com.theatre.model.MovieSchedule;
import com.theatre.model.UserDetail;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface MovieScheduleLogicI {

    MovieSchedule getScheduleById(int id);

    List<MovieSchedule> getScheduleStartTime(String startTime);

    Message removeScheduleByid(int id);

    Message addSchedule(MovieSchedule movieSchedule);

    List<MovieSchedule> getScheduleEndTime(String endTime);

    List<MovieSchedule> getScheduleByMovieName(String movieName);

    List<MovieSchedule> getScheduleByDate(String date);

    List<MovieSchedule> getScheduleByCinemaRoomName(String cinemaRoomName);

}
