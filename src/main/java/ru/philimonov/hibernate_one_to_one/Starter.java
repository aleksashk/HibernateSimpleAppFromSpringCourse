package ru.philimonov.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_one_to_one.entity.Detail;
import ru.philimonov.hibernate_one_to_one.entity.Employee;

public class Starter {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try(factory;session){
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            session.delete(employee);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
