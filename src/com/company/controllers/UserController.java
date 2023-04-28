package com.company.controllers;

import com.company.Database;
import com.company.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {

    public User createUser(User user) throws SQLException {
        System.out.println("Вызвал");
        Connection connection = new Database().getConnection();
        if (isIncludeUser(connection, user.getLogin())) {
            System.out.println("существует");
            connection.close();
            return null;
        } else {
            addUser(connection, user);
            connection.close();
        }
        return user;
    }

    public static User isValidUser(User user) throws SQLException {
        String sql = "SELECT * FROM Users WHERE login = ?";
        Connection connection = new Database().getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getLogin());
            ResultSet rs = stmt.executeQuery();
//            System.out.println("here");
            if (rs.next()) {
                if (user.getPassword().equals(rs.getString("password"))) {
                    user.setName(rs.getString("name"));
                    user.setId(rs.getInt("id"));
                } else return null;
            } else return null;
        } catch (SQLException e) {
//            System.out.println("123Нет соединения с базой данных");
            System.out.println(e);
        }
        return user;
    }

    private boolean isIncludeUser(Connection connection, String username) throws SQLException {
        String sql = "SELECT * FROM Users WHERE login = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            System.out.println("1Нет соединения с базой данных");
            return false;
        }
        return false;
    }

    private boolean addUser(Connection connection, User user) throws SQLException {
        String sql = "INSERT INTO Users (login, name, password) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getLogin()); // устанавливаем значение для первого параметра (login)
        pstmt.setString(2, user.getName()); // устанавливаем значение для второго параметра (name)
        pstmt.setString(3, user.getPassword()); // устанавливаем значение для третьего параметра (password)
        pstmt.executeUpdate(); // выполнение запроса на вставку данны
        return true;
    }

    public void getUsers() throws SQLException {
        Connection connection = new Database().getConnection();
        String sql = "SELECT * FROM Users";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) System.out.println(rs.getInt("id") + "\t"
                    + rs.getString("login") + "\t"
                    + rs.getString("name"));
        } catch (SQLException e) {
            System.out.println("Нет соединения с базой данных");
        }
        connection.close();
    }
}
