package com.theatre.ws.soap;

import com.theatre.bean.UserBeanI;
import com.theatre.model.UserDetail;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class UserSoapApi {

    @EJB
    private UserBeanI userBean;

    @WebMethod
    public List<UserDetail> helloWorld(){
        return userBean.list();
    }
}
