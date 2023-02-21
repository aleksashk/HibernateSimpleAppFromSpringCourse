package ru.philimonov.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_test.entity.Employee;

public class Starter2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            Employee employee = new Employee("Helen", "Carter", "Sales", 500);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            int myId = employee.getId();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(emp);
            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }

    }
}
