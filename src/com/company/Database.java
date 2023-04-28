package com.company;

import com.company.models.User;
import jdk.dynalink.Operation;
import java.sql.*;
import java.sql.Connection;
import  java.lang.Class;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    Connection connection;
    private final String url = "jdbc:sqlite:./database/db.db";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url);
    }

    public void closeConnection(Connection connection) throws SQLException {
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
