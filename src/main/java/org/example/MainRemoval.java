package org.example;

import org.example.entities.Guide;
import org.example.entities.Student;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class MainRemoval {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Student s1 = new Student();
        Student s2 = new Student();
        Guide guide = new Guide("John", "$1500", s1);
        Guide guide1 = new Guide("John", "$15000", s2);


        session.persist(s1);
        session.persist(s2);
        session.persist(guide);
        session.persist(guide1);


        Student studentget = session.get(Student.class, 2);
        Guide guideget = session.get(Guide.class, 1);
        guideget.setStudent(studentget);
        Object merge = session.merge(guideget);
        System.out.println(merge);

        session.getTransaction().commit();
    }
}
