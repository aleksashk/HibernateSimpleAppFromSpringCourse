package ru.philimonov.hibernate_one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_one_to_many.entity.Department;
import ru.philimonov.hibernate_one_to_many.entity.Employee;

public class Starter {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try (factory; session) {
//            Department department = new Department("IT", 300, 1200);
//            Employee employee1 = new Employee("Aleksandr", "Philimonov", 1100);
//            Employee employee2 = new Employee("Heleonora", "Smith", 800);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            session.beginTransaction();
//
//            session.save(department);

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
