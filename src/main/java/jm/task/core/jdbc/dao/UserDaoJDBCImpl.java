package jm.task.core.jdbc.dao;

import java.util.List;
import java.util.ArrayList;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;

public class UserDaoJDBCImpl implements UserDao {
//    private PreparedStatement preparedStatement = null;
    public UserDaoJDBCImpl() {
    }
    Connection conn = Util.getConnection();
    public void createUsersTable() {

        try (Statement state = conn.createStatement()) {
            if (!conn.isClosed()){
                System.out.println("Всё хорошо");
            } else {
                System.out.println("Не все хорошо");
            }
            state.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
                    "(id MEDIUMINT not null auto_increment," + " name VARCHAR(36), " + "lastname VARCHAR(36), " +
                    "age TINYINT, " + "PRIMARY KEY (id))");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement state = conn.createStatement()) {
            if (!conn.isClosed()){
                System.out.println("Всё хорошо");
            } else {
                System.out.println("Не все хорошо");
            }
            state.executeUpdate("DROP TABLE IF EXISTS users");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement prepa = conn.prepareStatement("INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)")) {
            if (!conn.isClosed()){
                System.out.println("Всё хорошо");
            } else {
                System.out.println("Не все хорошо");
            }
            prepa.setString(1, name);
            prepa.setString(2, lastName);
            prepa.setByte(3, age);
            prepa.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement state = conn.createStatement()) {
            if (!conn.isClosed()){
                System.out.println("Всё хорошо");
            } else {
                System.out.println("Не все хорошо");
            }
            state.executeUpdate("DELETE FROM test.users where id");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement state = conn.createStatement();
             ResultSet rs = state.executeQuery("SELECT * FROM users")) {
            if (!conn.isClosed()){
                System.out.println("Всё хорошо");
            } else {
                System.out.println("Не все хорошо");
            }
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setAge(rs.getByte("age"));
                users.add(user);
            }
        } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
            return users;
    }

    public void cleanUsersTable() {
        try (Statement state = conn.createStatement()) {
            if (!conn.isClosed()){
                System.out.println("Всё хорошо");
            } else {
                System.out.println("Не все хорошо");
            }
            state.executeUpdate("DELETE FROM users");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
