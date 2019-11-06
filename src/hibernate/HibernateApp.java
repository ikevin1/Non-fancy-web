package hibernate;

import hibernate.Entity.Comedian;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Comedian.class)
                .buildSessionFactory();
    }
    //close it to avoid connection leak
    public void close() {
        factory.close();
    }
//main method
    public static void main(String[] args) {
        HibernateApp hiber = new HibernateApp();

        try {
            hiber.createComedy();
            hiber.readComedy(1);
            hiber.updateComedy(1);
            hiber.deleteComedy(1);
            hiber.listAllComedi();

        } finally {
            hiber.close();
        }
    }
//create method for the object
private int createComedy() {
    Session session = factory.getCurrentSession();

    session.beginTransaction();

    /**  CRUD Below**/

    Comedian comedy = new Comedian(1, "XiXi", "I have the Micheal Boston voice to sing and add sweetness to your moment", "xixi.png", 5);

    session.save(comedy);

    System.out.println(comedy);

    session.getTransaction().commit();

    return comedy.getId();
}
//read method for the object
private void readComedy(int comedian_Id) {
    Session session = factory.getCurrentSession();

    session.beginTransaction();

    /**  CRUD Below**/
    Comedian acomedy = session.get(Comedian.class, comedian_Id);

    System.out.println(acomedy);

    session.getTransaction().commit();
}
//update method for the object
private void updateComedy(int comedian_Id) {
    Session session = factory.getCurrentSession();

    session.beginTransaction();

    /**  CRUD Below**/
    Comedian acomedy = session.get(Comedian.class, comedian_Id);
    if (acomedy != null)
        acomedy.setName(acomedy.getName().toUpperCase());
    System.out.println(acomedy);

    session.getTransaction().commit();
}
    //delete method for the object
    private void deleteComedy(int comedian_Id) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /**  CRUD Below**/
        Comedian acomedy = session.get(Comedian.class, comedian_Id);
        if (acomedy != null)
            session.delete(acomedy);


        session.getTransaction().commit();
    }
//list method for the object
    private void listAllComedi() {
    Session session = factory.getCurrentSession();

    session.beginTransaction();

    /**  CRUD Below**/
    List<Comedian> list = session.createQuery("from Comedian").getResultList();
    printComedianList(list);

    session.getTransaction().commit();
}
    //Print method for the object
    private void printComedianList(List<Comedian> list) {
        if (list.isEmpty()) {
            System.out.println("No donuts in list");
        } else {
            for (Comedian comedy : list) {
                System.out.println(comedy);
            }
        }
    }
    //update a particular ID method for the object
    //just change the where clause to have the ID you want to update

    //delete a particular ID - method for the object
    //just change the where clause to have the ID you want to delete
    private void deleteComedyOne() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /**  CRUD Below**/
        session.createQuery("delete from Comedian where id = 1").executeUpdate();

        session.getTransaction().commit();
    }
}
