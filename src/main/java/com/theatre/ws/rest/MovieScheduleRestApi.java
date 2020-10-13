package com.theatre.ws.rest;

import com.theatre.bean.MovieScheduleBeanI;
import com.theatre.logic.interfaces.MovieScheduleLogicI;
import com.theatre.model.Message;

import com.theatre.model.MovieSchedule;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/schedules")
public class MovieScheduleRestApi {

    @EJB
    private MovieScheduleBeanI movieScheduleBean;

    @EJB
    private MovieScheduleLogicI movieScheduleLogic;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return Response.status(200).entity(movieScheduleBean.list()).build();
    }

    @PUT
    @Path(value = "/addSchedule")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Message addUser(MovieSchedule movieSchedule) {
        return movieScheduleLogic.addSchedule(movieSchedule);
    }


    @GET
    @Path(value = "/findScheduleByMovieName/{movieName}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MovieSchedule> getScheduleByMovieName(@PathParam(value = "movieName") String movieName) {
        return movieScheduleLogic.getScheduleByMovieName(movieName);
    }

    @GET
    @Path(value = "/findScheduleByCinemaRoomName/{cinemaRoomName}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MovieSchedule>  getScheduleByCinemaRoomName(@PathParam(value = "cinemaRoomName") String cinemaRoomName) {
        return movieScheduleLogic.getScheduleByCinemaRoomName(cinemaRoomName);
    }

    @GET
    @Path(value = "/findScheduleByDate/{date}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MovieSchedule>  getScheduleByDate(@PathParam(value = "date") String date) {
        return movieScheduleLogic.getScheduleByDate(date);
    }

    @GET
    @Path(value = "/findScheduleByStartTime/{startTime}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MovieSchedule>  getScheduleStartTime(@PathParam(value = "startTime") String startTime) {
        return movieScheduleLogic.getScheduleStartTime(startTime);
    }

    @GET
    @Path(value = "/findScheduleByEndTime/{endTime}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MovieSchedule>  getScheduleEndTime(@PathParam(value = "endTime") String endTime) {
        return movieScheduleLogic.getScheduleEndTime(endTime);
    }


    @DELETE
    @Path("/removeScheduleById/{id}")
    public Message removeScheduleById(@PathParam("id") Integer id) {
        return movieScheduleLogic.removeScheduleByid(id);
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(MovieSchedule movieSchedule){
        try {
            movieScheduleBean.add(movieSchedule);
        }
        catch (Exception ex) {

            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }

}
