package com.water.music.bootstrap;

import com.water.music.entity.userinfo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public
class HibernateTests {
    private static SessionFactory sessionFactory;

    static {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            System.out.println("******************************************"+e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

    public void createUser(){
        Session session = getSession();
        User u = new User();
        u.setName("mengmiao");
        u.setNickName("nickmengmiao");
        session.save(u);

    }

    public static
    void main(String[] args) {
        HibernateTests ht = new HibernateTests();
        ht.createUser();
    }
}
