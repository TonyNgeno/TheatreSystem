package com.theatre.ws.soap;

import com.theatre.bean.MovieScheduleBeanI;
import com.theatre.logic.interfaces.MovieScheduleLogicI;
import com.theatre.model.Message;
import com.theatre.model.Movie;
import com.theatre.model.MovieSchedule;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "MovieScheduleSoapApi")
@Stateless()
public class MovieScheduleSoapApi {

    @EJB
    private MovieScheduleBeanI movieScheduleBean;

    @EJB
    private MovieScheduleLogicI movieScheduleLogic;


    @WebMethod(operationName = "listAllMovieSchedules")
    public List<MovieSchedule> listMovies(){
        return movieScheduleBean.list();
    }

    @WebMethod(operationName = "addSchedule")
    public Message addSchedule(@WebParam(name = "movieSchedule") MovieSchedule movieSchedule){
        return movieScheduleLogic.addSchedule(movieSchedule);}


    @WebMethod(operationName = "getMovieScheduleByMovieName")
    public List<MovieSchedule> getScheduleByMovieName(@WebParam(name = "name") String name) {
        return (List<MovieSchedule>) movieScheduleLogic.getScheduleByMovieName(name);
    }

    @WebMethod(operationName = "getMovieScheduleByCinemaRoomName")
    public List<MovieSchedule>  getScheduleByCinemaRoomName(@WebParam(name = "cinemaRoomName") String cinemaRoomName) {
        return (List<MovieSchedule>) movieScheduleLogic.getScheduleByCinemaRoomName(cinemaRoomName);
    }

    @WebMethod(operationName = "getScheduleById")
    public List<MovieSchedule>  getScheduleById(@WebParam(name = "id") int id) {
        return (List<MovieSchedule>) movieScheduleLogic.getScheduleById(id);
    }

    @WebMethod(operationName = "getScheduleByDate")
    public List<MovieSchedule>  getScheduleByDate(@WebParam(name = "date") String date) {
        return (List<MovieSchedule>) movieScheduleLogic.getScheduleByDate(date);
    }

    @WebMethod(operationName = "getScheduleStartTime")
    public List<MovieSchedule>  getScheduleStartTime(@WebParam(name = "startTime") String startTime) {
        return (List<MovieSchedule>) movieScheduleLogic.getScheduleStartTime(startTime);
    }

    @WebMethod(operationName = "getScheduleEndTime")
    public List<MovieSchedule>  getScheduleEndTime(@WebParam(name = "endTime") String endTime) {
        return (List<MovieSchedule>) movieScheduleLogic.getScheduleEndTime(endTime);
    }

    @WebMethod(operationName = "removeScheduleByid")
    public Message removeScheduleByid(@WebParam(name = "id") int id){
        return movieScheduleLogic.removeScheduleByid(id);
    }


    @WebMethod(operationName = "saveMovieSchedule")
    public String saveSchedule(MovieSchedule movieSchedule){
        try {
            movieScheduleBean.add(movieSchedule);
        } catch (Exception ex) {

            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";

        }
        return "{\"SUCCESS\":\"OK\"}";
    }



}
