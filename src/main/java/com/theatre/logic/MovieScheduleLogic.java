package com.theatre.logic;

import com.theatre.logic.interfaces.MovieScheduleLogicI;
import com.theatre.logic.interfaces.UserLogicI;
import com.theatre.model.Message;
import com.theatre.model.MovieSchedule;
import com.theatre.model.UserDetail;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote(MovieScheduleLogicI.class)
public class MovieScheduleLogic implements MovieScheduleLogicI {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public MovieSchedule getScheduleById(int id) {

        return entityManager.find(MovieSchedule.class, id);

    }

    @Override
    public List<MovieSchedule> getScheduleStartTime(String startTime) {
        try {
            Query query = entityManager.createNamedQuery("MovieSchedule.findByStartTime", MovieSchedule.class);
            query.setParameter("startTime", startTime);
            return (List<MovieSchedule>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Message removeScheduleByid(int id) {
        entityManager.remove(entityManager.find(MovieSchedule.class, id));
        return new Message(true, "Schedule Deleted Successfully", id);
    }

    @Override
    public Message addSchedule(MovieSchedule movieSchedule) {
        entityManager.merge(movieSchedule);
        return new Message(true, "Schedule Added Successfully", movieSchedule);

    }

    @Override
    public List<MovieSchedule> getScheduleEndTime(String endTime) {
        try {
            Query query = entityManager.createNamedQuery("MovieSchedule.findByEndTime", MovieSchedule.class);
            query.setParameter("endTime", endTime);
            return (List<MovieSchedule>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<MovieSchedule> getScheduleByMovieName(String movieName) {
        try {
            Query query = entityManager.createNamedQuery("MovieSchedule.findByMovieName", MovieSchedule.class);
            query.setParameter("movieName", movieName);
            return (List<MovieSchedule>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<MovieSchedule> getScheduleByDate(String date) {
        try {
            Query query = entityManager.createNamedQuery("MovieSchedule.findByDate", MovieSchedule.class);
            query.setParameter("date", date);
            return (List<MovieSchedule>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<MovieSchedule> getScheduleByCinemaRoomName(String cinemaRoomName) {
        try {
            Query query = entityManager.createNamedQuery("MovieSchedule.findByCinemaRoomName", MovieSchedule.class);
            query.setParameter("cinemaRoomName", cinemaRoomName);
            return (List<MovieSchedule>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


}
