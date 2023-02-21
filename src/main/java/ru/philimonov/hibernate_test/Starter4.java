package ru.philimonov.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_test.entity.Employee;

import java.util.List;

public class Starter4 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Employee set salary = 777000 where name = 'Aleksandr'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
