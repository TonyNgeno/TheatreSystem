package com.theatre.ws.soap;

import com.theatre.bean.RoomBeanI;
import com.theatre.logic.interfaces.RoomLogicI;
import com.theatre.model.Message;
import com.theatre.model.Room;
import com.theatre.model.UserDetail;
import com.theatre.ws.rest.RoomRestApi;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "RoomSoapApi")
@Stateless()
public class RoomSoapApi {

    @EJB
    private RoomBeanI roomBean;

    @EJB
    private RoomLogicI roomLogic;

    @WebMethod(operationName = "listRooms")
    public List<Room> listRooms(){
        return roomBean.list();
    }

    @WebMethod(operationName = "getRoomByName")
    public List<Room> getRoomByName(@WebParam(name = "name") String name) {
        return (List<Room>) roomLogic.getRoomByName(name);
    }

    @WebMethod(operationName = "addRoom")
    public Message addRoom(@WebParam(name = "room") Room room){
        return roomLogic.addRoom(room);
    }

    @WebMethod(operationName = "removeUserById")
    public Message removeUserById(@WebParam(name = "id") int id){
        return roomLogic.removeRoomByid(id);
    }


    @WebMethod(operationName = "saveRoom")
    public String saveRoom(Room room){
        try {
            roomBean.add(room);
        } catch (Exception ex) {

            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";

        }
        return "{\"SUCCESS\":\"OK\"}";
    }

}
