package com.lesson23.service.db;

import com.lesson23.service.Student;

import java.sql.*;
import java.util.*;


public class QueryCreateStudent {

    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public static void createStudent(Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into students(student_full_name, `group`, year_of_admission) value(?, ?, ?)");
        Student student = specify(connection);
        preparedStatement.setString(1, student.getFullName());
        preparedStatement.setInt(2, student.getGroup());
        preparedStatement.setInt(3, student.getYearOfAdmission());
        preparedStatement.executeUpdate();
    }

    public static void deleteStudent(Connection connection) throws SQLException {
        getStudents(connection);
        Scanner scanner = new Scanner(System.in);
        Integer i = null;
        while (true) {
            System.out.println("Specify student id");
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                break;
            } else {
                System.err.println("Specify student id");
                scanner.next();
            }
        }
        preparedStatement = connection.prepareStatement("delete from students where id_student = " + i);
        preparedStatement.executeUpdate();
    }

    public static void getStudents(Connection connection) throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select id_student, student_full_name from students");
        while (resultSet.next()) {
            System.out.printf("%-8s", "id: " + resultSet.getInt(1));
            System.out.printf("%-10s", "full name: " + resultSet.getString(2));
            System.out.println();
        }
    }

    private static Student specify(Connection connection) throws SQLException {
        Calendar calendar = new GregorianCalendar();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select id_group from `groups`");
        List<Integer> listGroup = new ArrayList<>();
        while (resultSet.next()) listGroup.add(resultSet.getInt(1));

        String fullName;
        int idGroup = 0;
        int yearOfAdmission;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Specify student's full name");
        fullName = scanner.nextLine();

        boolean flag = false;
        while (!flag) {
            System.out.print("Specify group id |");
            listGroup.forEach(i -> System.out.print(i + "|"));
            System.out.println();
            if (scanner.hasNextInt()) {
                idGroup = scanner.nextInt();
                for (int i = 0; i < listGroup.size(); i++) {
                    if (listGroup.get(i) == idGroup) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        while (true) {
            System.out.println("Specify year of admission");
            if (scanner.hasNextInt()) {
                yearOfAdmission  = scanner.nextInt();
                if (yearOfAdmission <= calendar.getWeekYear()) break;
                else System.err.println("Wrong year > " + calendar.getWeekYear());
            } else {
                System.err.println("Wrong year");
                scanner.next();
            }
        }
        return new Student(fullName, idGroup, yearOfAdmission);
    }
}
