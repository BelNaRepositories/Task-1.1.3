package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl fromdao = new UserDaoJDBCImpl();
    public void createUsersTable() {
        fromdao.createUsersTable();
    }

    public void dropUsersTable() {
        fromdao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        fromdao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        fromdao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return fromdao.getAllUsers();
    }

    public void cleanUsersTable() {
        fromdao.cleanUsersTable();
    }
}
