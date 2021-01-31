package com.lesson23;

import com.lesson23.service.db.DbConnected;
import com.lesson23.service.db.QueryCreateStudent;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnected.DbConnected();
        connection.setAutoCommit(false);
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            try {
                System.out.println("1 - create student | 2 - delete student | 3 - show all student | 4 - exit");
                if (scanner.hasNextInt()) {
                    int i = scanner.nextInt();
                    if (i < 5) {
                        switch (i) {
                            case 1:
                                QueryCreateStudent.createStudent(connection);
                                break;
                            case 2:
                                QueryCreateStudent.deleteStudent(connection);
                                break;
                            case 3:
                                QueryCreateStudent.getStudents(connection);
                                break;
                            case 4:
                                flag = true;
                        }
                    } else {
                        System.err.println("wrong number");
                        continue;
                    }
                } else scanner.next();

            connection.commit();
            } catch (SQLException throwables) {
                connection.rollback();
                throwables.printStackTrace();
            }
        }
    }
}
