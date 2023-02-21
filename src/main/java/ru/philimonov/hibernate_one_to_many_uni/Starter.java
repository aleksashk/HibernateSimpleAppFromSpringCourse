package ru.philimonov.hibernate_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_one_to_many_uni.entity.Department;
import ru.philimonov.hibernate_one_to_many_uni.entity.Employee;

public class Starter {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try (factory; session) {
//            Department department = new Department("HR", 500, 1500);
//            Employee employee1 = new Employee("David", "Manucan", 1300);
//            Employee employee2 = new Employee("Elza", "Schmidt", 1100);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            session.beginTransaction();
//
//            session.save(department);
//***************************************************************
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 4);
//            session.delete(employee);

            session.beginTransaction();
            Department department = session.get(Department.class, 2);
            System.out.println(department);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
