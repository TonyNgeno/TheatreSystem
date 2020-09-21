package com.theatre.ws.soap;

import com.theatre.bean.UserBeanI;
import com.theatre.logic.interfaces.UserLogicI;
import com.theatre.model.Message;
import com.theatre.model.UserDetail;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.List;

@WebService(name = "UserSoapApi")
public class UserSoapApi {

    @EJB
    private UserBeanI userBean;

    @EJB
    private UserLogicI userLogic;

    @WebMethod(operationName = "listAllUsers")
    public List<UserDetail> helloWorld(){
        return userBean.list();
    }

    @WebMethod(operationName = "getUserById")
    public UserDetail getUserById(@WebParam(name = "id") int id){
        return userLogic.getUserById(id);
    }

    @WebMethod(operationName = "getUserByEmail")
    public UserDetail getUserByEmail(@WebParam(name = "email") String email){
        return userLogic.getUserByEmail(email);
    }

    @WebMethod(operationName = "getUserByNameAndPassword")
    public UserDetail getUserByNameAndPassword(@WebParam(name = "username") String username, @WebParam(name = "password") String password){
        return userLogic.getUserByUsernameAndPassword(username, password);
    }

    @WebMethod(operationName = "addUser")
    public Message addUser(@WebParam(name = "userDetail") UserDetail userDetail){
        return userLogic.addUser(userDetail);
    }

    @WebMethod(operationName = "removeUserById")
    public Message removeUserById(@WebParam(name = "id") int id){
        return userLogic.removeUserByid(id);
    }


    @WebMethod(operationName = "saveUsers")
    public String save(UserDetail userDetail){
        try {
            userBean.add(userDetail);
        } catch (Exception ex) {
            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
            }
        return "{\"SUCCESS\":\"OK\"}";
    }










}
