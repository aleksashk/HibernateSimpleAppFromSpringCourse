package ru.philimonov.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_one_to_one.entity.Detail;
import ru.philimonov.hibernate_one_to_one.entity.Employee;

public class Starter2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try (factory; session) {
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 2);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
