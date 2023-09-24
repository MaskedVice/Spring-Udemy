package com.springudemy.springsecurity.springsecurity.dao;

import org.springframework.stereotype.Repository;

import com.springudemy.springsecurity.springsecurity.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String userName) {
        TypedQuery<User> theQuery = entityManager.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", userName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }
        return theUser;
    }

}
