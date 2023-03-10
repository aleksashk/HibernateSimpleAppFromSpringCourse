package ru.philimonov.hibernate_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_one_to_many_bi.entity.Department;
import ru.philimonov.hibernate_one_to_many_bi.entity.Employee;

public class Starter {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try (factory; session) {
//            Department department = new Department("Sales", 300, 1200);
//            Employee employee1 = new Employee("Aleksandr", "Philimonov", 1100);
//            Employee employee2 = new Employee("Heleonora", "Smith", 800);
//            Employee employee3 = new Employee("Jorge", "Cluni", 900);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            department.addEmployeeToDepartment(employee3);
//            session.beginTransaction();
//
//            session.save(department);
//********************************************************************************
            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 4);
//            session.delete(employee);

            System.out.println("Get department");
            Department department = session.get(Department.class, 5);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
