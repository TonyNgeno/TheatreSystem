package com.theatre.logic;

import com.theatre.logic.interfaces.UserLogicI;
import com.theatre.model.Message;
import com.theatre.model.UserDetail;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class UserLogic implements UserLogicI {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public UserDetail getUser(int id) {
        return entityManager.find(UserDetail.class, id);
    }

    @Override
    public UserDetail getUser(UserDetail userDetail) {
        try {
            Query query = entityManager.createQuery("SELECT u FROM UserDetail u WHERE u.username = :username AND u.password = :password");
            query.setParameter("username", userDetail.getUsername());
            query.setParameter("password", userDetail.getPassword());
            return (UserDetail) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Message addUser(UserDetail userDetail) {
        entityManager.merge(userDetail);
        return new Message(true, "User is successfully added", userDetail);
    }

    @Override
    public Message removeUser(UserDetail userDetail) {
        entityManager.remove(entityManager.find(UserDetail.class, userDetail));
        return new Message(true, "User Deleted Successfully", userDetail);
    }

    @Override
    public List<UserDetail> getUsers(int limit) {
         if (limit == -1) {
            return entityManager.createNamedQuery("Users.findAllOrdered").getResultList();
        }

        Query query = entityManager.createNamedQuery("Users.findAllOrdered");
        query.setMaxResults(limit);
        return query.getResultList();
    }
}
