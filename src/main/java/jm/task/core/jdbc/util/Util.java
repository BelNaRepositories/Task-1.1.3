package jm.task.core.jdbc.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Util {
    public static Connection conn;
    public static Connection getConnection() {
        String dbURL = "jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Moscow&useSSL=false";
        String login = "root";
        String password = "q1w2E3r$t!!!!";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, login, password);
            System.out.print("Всё хорошо и ");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Не всё хорошо и ");
        } return conn;
    }
}