package com.theatre.ws.rest;

import com.theatre.bean.RoomBeanI;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/room")
public class RoomRestApi {

    @EJB
    private RoomBeanI roomBean;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return Response.status(200).entity(roomBean.list()).build();
    }
}
