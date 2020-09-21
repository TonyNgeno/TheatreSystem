package com.theatre.logic.interfaces;

import com.theatre.model.Message;
import com.theatre.model.UserDetail;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserLogicI {

    UserDetail getUserById(int id);

    UserDetail getUserByEmail(String email);

    UserDetail getUserByUsernameAndPassword(String username, String password);

    UserDetail getUser(UserDetail userDetail);

    Message addUser(UserDetail userDetail);

    Message removeUser(UserDetail userDetail);

    Message removeUserByid(int id);

    Message updateUser(UserDetail userDetail);

    List<UserDetail> getUsers(int limit);
}
