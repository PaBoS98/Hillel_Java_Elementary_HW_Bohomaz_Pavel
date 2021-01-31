package com.lesson23.service.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnected {
        public static Connection DbConnected() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/student?"
                            + "useSSL=false&user=root&password=root&serverTimezone=UTC");
           return connection;
        }
}
