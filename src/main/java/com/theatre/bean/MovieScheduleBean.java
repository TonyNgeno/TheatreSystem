package com.theatre.bean;

import com.theatre.model.Movie;
import com.theatre.model.MovieSchedule;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
public class MovieScheduleBean implements MovieScheduleBeanI{

    @PersistenceContext
    private EntityManager em;


    @Override
    public String add(MovieSchedule movieSchedule) {
        em.merge(movieSchedule);

        return "ok";
    }

    @Override
    public List<MovieSchedule> list() {
        return em.createQuery("From MovieSchedule ms").getResultList();
    }
}
