package ru.kolobkevic.homework.lesson_5.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import ru.kolobkevic.homework.lesson_5.crud.SessionFactoryUtils;
import ru.kolobkevic.homework.lesson_5.entity.Student;

import java.util.List;

public class StudentDao {
    public SessionFactoryUtils factory;

    public StudentDao() {
    }

    public StudentDao(SessionFactoryUtils factory) {
        this.factory = new SessionFactoryUtils();
    }

    public Student findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    public List<Student> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("select s from Student s ORDER BY s.id").getResultList();
            Hibernate.initialize(students);
            session.getTransaction().commit();
            return students;
        }
    }

    public void deleteById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Student where id= :id").setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Student save(Student student) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
            return student;
        }
    }

    public Student update(Student student) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
            return student;
        }
    }
}