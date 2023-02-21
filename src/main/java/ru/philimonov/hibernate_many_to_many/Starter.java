package ru.philimonov.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.philimonov.hibernate_many_to_many.entity.Child;
import ru.philimonov.hibernate_many_to_many.entity.Section;

public class Starter {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Child.class).addAnnotatedClass(Section.class).buildSessionFactory(); Session session = factory.getCurrentSession()) {
            session.beginTransaction();


            Section section = new Section("Footbal");

            Child child1 = new Child("Aleks", 5);
            Child child2 = new Child("Lena", 6);
            Child child3 = new Child("Dasha", 4);


            session.save(section);

            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);


            session.save(child1);
            session.save(child2);
            session.save(child3);
//************************************************************************************
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Karate");
//            Section section3 = new Section("Hockey");
//
//            Child child = new Child("Roma", 9);
//            child.addSectionToChild(section1);
//            child.addSectionToChild(section2);
//            child.addSectionToChild(section3);

            //************************************************************************************
//            Section section = session.get(Section.class, 5);
//            System.out.println(section);
//            System.out.println(section.getChildren());
            //************************************************************************************

//            Child child = session.get(Child.class, 7);
//            System.out.println(child);
//            System.out.println(child.getSections());

            //************************************************************************************

//            Section section = session.get(Section.class, 2);
//            session.delete(section);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
    }
}
