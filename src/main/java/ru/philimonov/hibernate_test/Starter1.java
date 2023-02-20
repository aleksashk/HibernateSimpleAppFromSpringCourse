package ru.philimonov.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_test.entity.Employee;

public class Starter1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            Employee employee = new Employee("Grigory", "Pal", "HR", 4500);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
