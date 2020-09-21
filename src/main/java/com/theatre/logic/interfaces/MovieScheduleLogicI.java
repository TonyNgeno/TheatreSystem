package com.theatre.logic.interfaces;

import com.theatre.model.Message;
import com.theatre.model.MovieSchedule;

import javax.ejb.Remote;

@Remote
public interface MovieScheduleLogicI {

    MovieSchedule getScheduleById(int id);

    MovieSchedule getScheduleStartTime(String startTime);

    Message removeScheduleByid(int id);

    Message addSchedule(MovieSchedule movieSchedule);

    MovieSchedule getScheduleEndTime(String endTime);

    MovieSchedule getScheduleByMovieName(String movieName);

    MovieSchedule getScheduleByDate(String date);

    MovieSchedule getScheduleByCinemaRoomName(String cinemaRoomName);

}
