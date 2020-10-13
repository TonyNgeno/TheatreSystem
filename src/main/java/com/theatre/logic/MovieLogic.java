package com.theatre.logic;

import com.theatre.logic.interfaces.MovieLogicI;
import com.theatre.logic.interfaces.UserLogicI;
import com.theatre.model.Message;
import com.theatre.model.Movie;
import com.theatre.model.UserDetail;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote(MovieLogicI.class)
public class MovieLogic implements MovieLogicI {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Movie> getMovieByName(String name) {
        try {
            Query query = entityManager.createNamedQuery("Movie.findByName", Movie.class);
            query.setParameter("movieName", name);
            return (List<Movie>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Message removeMovieByid(int id) {
        entityManager.remove(entityManager.find(Movie.class, id));
        return new Message(true, "Movie Deleted Successfully", id);
    }

    @Override
    public Message addMovie(Movie movie) {
        entityManager.merge(movie);
        return new Message(true, "Movie is successfully added", movie);
    }
}
