package edu.wctc.myComic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComedianNameDAOImpl implements ComedianNameDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<String> getNames() {
        Session session = sessionFactory.getCurrentSession();

        List<String> list = session.createQuery("from String", String.class).getResultList();

        return list;
    }

    @Override
    public String getName(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(String.class, id);
    }
}
