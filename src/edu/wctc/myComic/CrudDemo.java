package edu.wctc.myComic;

import edu.wctc.myComic.entity.Comedian;
import edu.wctc.myComic.entity.ComedianName;
import edu.wctc.myComic.entity.ComedianNameDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class CrudDemo {
    private SessionFactory factory;

    public CrudDemo() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Comedian.class)
                .addAnnotatedClass(ComedianName.class)
                .addAnnotatedClass(ComedianNameDetail.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        CrudDemo demo = new CrudDemo();

        try {
            demo.deleteNameAndDetail();
        } finally {
            demo.close();
        }
    }


    private void deleteComedian2(int comedianId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Comedian doomedComedian = session.get(Comedian.class, comedianId);

        if (doomedComedian == null){
            System.out.println("No comedian for ID " + comedianId);
        } else {
            session.delete(doomedComedian);
        }

        session.getTransaction().commit();
    }

    private void getComediansForName(int nameId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        ComedianName aName = session.get(ComedianName.class, nameId);

        for (Comedian aComedian : aName.getComedians()) {
            System.out.println(aComedian);
        }

        session.getTransaction().commit();
    }

    private void createComediansForName(int nameId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        ComedianName aName = session.get(ComedianName.class, nameId);

        Comedian comedian1 = new Comedian("xi", 390, "input xi detail here",  50 new Date());
        Comedian comedian2 = new Comedian("jo", 285, "input their", 50 new Date());

        aName.add(comedian1);
        aName.add(comedian2);

        session.save(comedian1);
        System.out.println(comedian1);
        session.save(comedian2);
        System.out.println(comedian2);

        session.getTransaction().commit();
    }

    private void deleteDetail() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        ComedianNameDetail detail = session.get(ComedianNameDetail.class, 1);
        detail.getName().setDetail(null);
        //detail.setShop(null);

        session.delete(detail);

        session.getTransaction().commit();
    }

    private void deleteNameAndDetail() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        ComedianName myName = session.get(ComedianName.class, 301);

        session.delete(myName);

        //System.out.println(myName);

        session.getTransaction().commit();
    }

    private void createNameAndDetail() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        ComedianName name = new ComedianName("Kevin's Comedian", "Kevin's-comedians");
        ComedianNameDetail detail = new ComedianNameDetail();
        name.setDetail(detail);

        session.save(name);

        session.getTransaction().commit();
    }

    private void deleteComedian(int comedianId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Comedian doomedComedian = session.get(Comedian.class, comedianId);
        if(doomedComedian != null)
            session.delete(doomedComedian);

        session.getTransaction().commit();
    }

    private void deleteComedianTen() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        session.createQuery("delete from Comedian where id = 1").executeUpdate();

        session.getTransaction().commit();
    }

    private void updateDate() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Comedian aComedian = session.get(Comedian.class, 2);
        aComedian.setDateAdded(DateUtils.parseDate("01/01/2020"));

        session.getTransaction().commit();
    }

    private void updateImageFile() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Comedian> list = session.createQuery("from Comedian").getResultList();
        for (Comedian aComedian : list) {
            String newFileName = aComedian.getPicture().replaceAll("-", "_");
            aComedian.setPicture(newFileName);
        }


        session.getTransaction().commit();
    }

    private void updateOneComedian() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Comedian> list = session.createQuery("from Comedian order by name desc").getResultList();
        list.get(0).setName("I could be a super comedian");

        session.getTransaction().commit();
    }

    private void updateAllComedians() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        session.createQuery("update Comedian set description = descriptions + comic").executeUpdate();

        session.getTransaction().commit();
    }

    private void updateComedian(int comedianId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Comedian aComedian = session.get(Comedian.class, comedianId);
        if (aComedian != null)
            aComedian.setName(aComedian.getName() + " UPDATED");

        session.getTransaction().commit();
    }

    private void listAllComedians() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Comedian> list = session.createQuery("from Comedian where name = 'm' order by dateAdded desc").getResultList();

        printComedianList(list);

        session.getTransaction().commit();
    }

    private void printComedianList(List<Comedian> list) {
        if (list.isEmpty()) {
            System.out.println("No comedian(s) found in our list");
        } else {
            for (Comedian comedian : list) {
                System.out.println(comedian);
            }
        }
    }

    private void readComedian(int comedianId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Comedian aComedian = session.get(Comedian.class, comedianId);

        if (aComedian == null){
            System.out.println("No Comedian found for this ID " + comedianId);
        } else {
            System.out.println(aComedian);
        }

        session.getTransaction().commit();
    }

    private int createComedian() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Date sepFirst = DateUtils.parseDate("09/01/2019");
        Comedian comedian = new Comedian("Bessie", 309, "bessie.png", sepFirst);

        session.save(comedian);

        session.getTransaction().commit();

        return comedian.getId();
    }



    private void close() {
        factory.close();
    }
}