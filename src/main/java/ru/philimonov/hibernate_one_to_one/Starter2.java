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
            Employee employee = new Employee("Jorge", "Cluni", "HR", 700);
            Detail detail = new Detail("New York", "147-369-004", "clunca@gmail.com");
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
