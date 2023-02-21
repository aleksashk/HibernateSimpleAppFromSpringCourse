package ru.philimonov.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_one_to_one.entity.Detail;
import ru.philimonov.hibernate_one_to_one.entity.Employee;

public class Starter {
    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory()){
//            Employee employee = new Employee("Boris", "Jonson", "HR", 300);
//            Detail detail = new Detail("London", "025-54-89", "jonson@gmail.com");
//            employee.setEmpDetail(detail);
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            session.save(employee);

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
