package com.theatre.ws.rest;

import com.theatre.bean.MovieBeanI;
import com.theatre.logic.interfaces.MovieLogicI;
import com.theatre.logic.interfaces.UserLogicI;
import com.theatre.model.Message;
import com.theatre.model.Movie;
import com.theatre.model.UserDetail;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/movies")
public class MovieRestApi {

    @EJB
    private MovieBeanI movieBean;

    @EJB
    private MovieLogicI movieLogic;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return Response.status(200).entity(movieBean.list()).build();
    }

    @PUT
    @Path(value = "/addMovie")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Message addUser(Movie movie) {
        return movieLogic.addMovie(movie);
    }


    @GET
    @Path(value = "/findMovieByName/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movie> getMovieByName(@PathParam(value = "name") String name) {
        return movieLogic.getMovieByName(name);
    }

    @DELETE
    @Path("/removeMovieById/{id}")
    public Message removeMovieById(@PathParam("id") Integer id) {
        return movieLogic.removeMovieByid(id);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Movie movie){
        try {
            movieBean.add(movie);
        }
        catch (Exception ex) {

            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }
}
