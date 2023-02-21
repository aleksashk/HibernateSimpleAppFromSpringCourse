package ru.philimonov.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_test.entity.Employee;

public class Starter5 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
