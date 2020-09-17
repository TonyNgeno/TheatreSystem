package com.theatre.ws.soap;

import com.theatre.bean.RoomBeanI;
import com.theatre.model.Room;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class RoomSoapApi {

    @EJB
    private RoomBeanI roomBean;

    @WebMethod
    public List<Room> helloWorld(){
        return roomBean.list();
    }

}
