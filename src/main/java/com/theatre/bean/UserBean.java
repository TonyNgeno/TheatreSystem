package com.theatre.bean;

import com.theatre.model.UserDetail;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Remote
public class UserBean implements UserBeanI{

    @PersistenceContext
    private EntityManager em;


    @Override
    public String add(UserDetail userDetail) {
        em.merge(userDetail);

        return "ok";
    }

        @Override
    public List<UserDetail> list() {
        return em.createQuery("From UserDetail u").getResultList();
    }

    @Override
    public String delete(UserDetail userDetail) {
        em.remove(userDetail);
        return "ok";
    }
}
