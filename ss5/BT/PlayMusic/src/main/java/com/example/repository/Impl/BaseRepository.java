package com.example.repository.Impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BaseRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
        return entityManager;
    }

    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }
}
