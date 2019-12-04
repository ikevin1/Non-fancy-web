package edu.wctc.myComic.dao;

import edu.wctc.myComic.entity.ComedianName;
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
    public List<ComedianName> getNames() {
        Session session = sessionFactory.getCurrentSession();

        List<ComedianName> list = session.createQuery("from ComedianName", ComedianName.class).getResultList();

        return list;
    }

    @Override
    public ComedianName getName(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(ComedianName.class, id);
    }
}
