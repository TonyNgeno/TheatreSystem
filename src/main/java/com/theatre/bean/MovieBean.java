package com.theatre.bean;

import com.theatre.model.Movie;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class MovieBean implements MovieBeanI {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String add(Movie movie) {
        em.merge(movie);

        return "ok";

    }

    @Override
    public List<Movie> list() {
        return em.createQuery("From Movie m").getResultList();
    }

}
