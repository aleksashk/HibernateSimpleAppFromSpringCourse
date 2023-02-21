package ru.philimonov.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_many_to_many.entity.Child;
import ru.philimonov.hibernate_many_to_many.entity.Section;

public class Starter {
    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Child.class).addAnnotatedClass(Section.class).buildSessionFactory(); Session session = factory.getCurrentSession()){


            Section section = new Section("Footbal");

            Child child1 = new Child("Aleks", 5);
            Child child2 = new Child("Lena", 6);
            Child child3 = new Child("Dasha", 4);

            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);

            session.beginTransaction();

            session.save(section);

            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
    }
}
