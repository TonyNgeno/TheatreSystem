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
@Remote(UserLogicI.class)
public class UserLogic implements UserLogicI {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public UserDetail getUserById(int id) {
        return entityManager.find(UserDetail.class, id);
    }

    @Override
    public UserDetail getUserByEmail(String email) {
        try {
            Query query = entityManager.createNamedQuery("UserDetail.findByEmail", UserDetail.class);
            query.setParameter("userEmail", email);
            return (UserDetail) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public UserDetail getUserByUsernameAndPassword(String username, String password) {
        try {
            Query query = entityManager.createQuery("SELECT u FROM UserDetail u WHERE u.contact.email = :username OR u.username = :username AND u.password = :usrPwd");
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (UserDetail) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
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
    public Message removeUserByid(int id) {
        entityManager.remove(entityManager.find(UserDetail.class, id));
        return new Message(true, "User Deleted Successfully", id);
    }

    @Override
    public Message updateUser(UserDetail userDetail) {
        entityManager.merge(userDetail);
        return new Message(true, "User information updated");
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
