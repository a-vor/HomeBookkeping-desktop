package com.company.services;

import com.company.Database;
import com.company.controllers.UserController;
import com.company.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {
    public void register(User user, Connection connection) {
        String sql = "INSERT INTO Users (login, name, password) VALUES (?, ?, ?)";
        Database database = new Database();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Соединение с базой данных закрыто.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия соединения с базой данных");
            e.printStackTrace();
        }
    }

}
