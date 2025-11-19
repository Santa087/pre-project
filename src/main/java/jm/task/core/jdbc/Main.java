package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();

        userDao.saveUser("John", "Smith", (byte) 20);
        userDao.saveUser("Alice", "Henderson", (byte) 25);
        userDao.saveUser("Mark", "Brown", (byte) 31);
        userDao.saveUser("Bob", "Davis", (byte) 38);

        List<User> users = userDao.getAllUsers();
        System.out.println("Все пользователи:");
        for (User user : users) {
            System.out.println(user);
        }

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

    }
}
