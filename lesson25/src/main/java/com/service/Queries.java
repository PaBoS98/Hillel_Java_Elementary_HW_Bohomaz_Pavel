package com.service;

import com.entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Queries {

    public static List<Student> getStudent (Session session) {
        return session.createQuery("from Student").list();
    }

    public static Student getStudent (Session session, int id) {
        return (Student) session.createQuery("from Student as s where s.idStudent = " + id).uniqueResult();
    }

    public static Student getStudent (Session session, String fullName) {
        return (Student) session.createQuery("from Student as s where s.studentFullName = '" + fullName+"'").uniqueResult();
    }

    public static void addStudent(Session session, Student newStudent) {
        session.save(newStudent);
        session.getTransaction().commit();
    }
}
