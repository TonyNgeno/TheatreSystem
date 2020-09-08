package com.theatre.bean;


import com.theatre.model.MovieSchedule;

import java.sql.Connection;
import java.util.List;

public interface MovieScheduleBeanI {
    String add(MovieSchedule movieSchedule);

    List<MovieSchedule> list();
}
