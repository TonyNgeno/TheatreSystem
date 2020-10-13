package com.theatre.ws.rest;

import com.theatre.bean.UserBeanI;
import com.theatre.logic.interfaces.UserLogicI;
import com.theatre.model.Message;
import com.theatre.model.Room;
import com.theatre.model.UserDetail;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UsersRestApi {

    @EJB
    private UserBeanI userBean;

    @EJB
    private UserLogicI userLogic;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return Response.status(200).entity(userBean.list()).build();
    }


    @GET
    @Path(value = "/findUserById/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public UserDetail getUserById(@PathParam(value = "id") int id) {
        return userLogic.getUserById(id);
    }

    @GET
    @Path(value = "/findUserByEmail/{email}")
    @Produces({MediaType.APPLICATION_JSON})
    public UserDetail getUserByEmail(@PathParam(value = "email") String email) {
        return userLogic.getUserByEmail(email);
    }

    @POST
    @Path(value = "/getUserByNameAndPassword/{email}/{password}")
    @Produces({MediaType.APPLICATION_JSON})
    public UserDetail getUserByUsernameAndPassword(@PathParam(value = "username") String username, @PathParam(value = "password") String password) {
        return userLogic.getUserByUsernameAndPassword(username, password);
    }

    @PUT
    @Path(value = "/addUser")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Message addUser(UserDetail userDetail) {
        return userLogic.addUser(userDetail);
    }

    @POST
    @Path(value = "/removeUser")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Message removeUser(UserDetail userDetail) {
        return userLogic.removeUser(userDetail);
    }


    @POST
    @Path(value = "/updateUser")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Message updateUser(UserDetail userDetail) {
        return userLogic.updateUser(userDetail);
    }

    @DELETE
    @Path("/removeUserById/{id}")
    public Message removeUserById(@PathParam("id") Integer id) {
        return userLogic.removeUserByid(id);
    }

    @GET
    @Path(value = "/getUsers/{limit}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<UserDetail> getUsers(@PathParam(value = "limit") int limit) {
        return userLogic.getUsers(limit);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(UserDetail userDetail){
        try {
            userBean.add(userDetail);
        }
        catch (Exception ex) {

            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }

}