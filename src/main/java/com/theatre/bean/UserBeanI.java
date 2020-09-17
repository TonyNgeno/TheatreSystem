package com.theatre.bean;

import com.theatre.model.UserDetail;

import java.util.List;

public interface UserBeanI {

    String add(UserDetail userDetail);

    List<UserDetail> list();

    String delete(UserDetail userDetail);
}
