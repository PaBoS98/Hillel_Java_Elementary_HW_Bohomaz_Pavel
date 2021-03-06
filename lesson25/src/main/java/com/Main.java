package com;

import com.entity.Group;
import com.entity.Student;
import com.service.HibernateUtil;
import com.service.Queries;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Session session;

    public static void main(String[] args) {


//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        System.out.println("Show all students");
//        System.out.println(Queries.getStudent(session));
//        System.out.println("------------------------------------------");
//        System.out.println("Add new student");
//        Queries.addStudent(session, specify());
//        System.out.println("------------------------------------------");
//        System.out.println("Show all students");
//        System.out.println(Queries.getStudent(session));
//        System.out.println("------------------------------------------");
//        System.out.println("Show student by id 5");
//        System.out.println(Queries.getStudent(session, 2));
//        System.out.println("------------------------------------------");
//        System.out.println("Show a student whose name is Elon Musk");
//        System.out.println(Queries.getStudent(session, "Blinova Khana Glebovna"));

    }

    private static Student specify() {
        Scanner scanner = new Scanner(System.in);
        Student newStudent = new Student();

        System.out.println("specify the full name of the student");
        newStudent.setStudentFullName(scanner.nextLine());

        List<Group> groupList = session.createQuery("from Group").list();
        group: while (true) {
            System.out.println("specify group");
            for (Group g : groupList) System.out.println(g);
            if (scanner.hasNextInt()) {
                int group = scanner.nextInt();
                for (int i = 0; i < groupList.size(); i++) {
                    if (group == groupList.get(i).getIdGroup()) {
                        newStudent.setGroup(group);
                        break group;
                    }
                }
                System.err.println("wrong group");
            }  else {
                System.err.println("wrong group");
                scanner.next();
            }
        }

        Calendar calendar = new GregorianCalendar();
        while (true) {
            System.out.println("specify the year of admission of the student");
            if (scanner.hasNextInt()) {
                int yearOfAdmission  = scanner.nextInt();
                if (yearOfAdmission <= calendar.getWeekYear()){
                    newStudent.setYearOfAdmission(yearOfAdmission);
                    break;
                } else System.err.println("Wrong year > " + calendar.getWeekYear());
            } else {
                System.err.println("Wrong year");
                scanner.next();
            }
        }
        return newStudent;
    }

    public static void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 3) return;
        }
    }
}
