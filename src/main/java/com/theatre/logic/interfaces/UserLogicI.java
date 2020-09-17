package com.theatre.logic.interfaces;

import com.theatre.model.Message;
import com.theatre.model.UserDetail;

import java.util.List;

public interface UserLogicI {

    UserDetail getUser(int id);

    UserDetail getUser(UserDetail userDetail);

    Message addUser(UserDetail userDetail);

    Message removeUser(UserDetail userDetail);

    List<UserDetail> getUsers(int limit);
}
