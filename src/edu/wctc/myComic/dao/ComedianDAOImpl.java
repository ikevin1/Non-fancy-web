package edu.wctc.myComic.dao;

import edu.wctc.myComic.entity.Comedian;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComedianDAOImpl implements ComedianDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Comedian> getComedians() {
        Session session = sessionFactory.getCurrentSession();

        List<Comedian> list = session.createQuery("from Comedian", Comedian.class).getResultList();

        return list;
    }

    @Override
    public void saveComedian(Comedian aComedian) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(aComedian);
    }

    @Override
    public Comedian getComedian(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Comedian.class, theId);
    }

    @Override
    public void deleteComedian(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Comedian where id = :doomedComedianId");

        query.setParameter("doomedComedianId", theId);

        query.executeUpdate();
    }

    @Override
    public List<Comedian> getComediansByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Comedian> query = session.createQuery("from Comedian where lower(name) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }

}
