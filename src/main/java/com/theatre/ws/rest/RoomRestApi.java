package com.theatre.ws.rest;

import com.theatre.bean.RoomBeanI;
import com.theatre.logic.interfaces.RoomLogicI;
import com.theatre.model.Message;
import com.theatre.model.Movie;
import com.theatre.model.Room;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/room")
public class RoomRestApi {

    @EJB
    private RoomBeanI roomBean;

    @EJB
    private RoomLogicI roomLogic;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){ ;
        return Response.status(200).entity(roomBean.list()).build();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam(value = "id") int id ){ ;
        return Response.status(200).entity(roomBean.list()).build();
    }

    @GET
    @Path(value = "/findRoomByName/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Room getRoomByName(@PathParam(value = "name") String name) {
        return roomLogic.getRoomByName(name);
    }


    @PUT
    @Path(value = "/addRoom")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Message addRoom(Room room) {
        return roomLogic.addRoom(room);
    }


    @DELETE
    @Path("/removeRoomById/{id}")
    public Message removeRoomById(@PathParam("id") Integer id) {
        return roomLogic.removeRoomByid(id);
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  String saveRoom(Room room){
        try {
            roomBean.add(room);
        }
        catch (Exception ex) {

            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }
}
