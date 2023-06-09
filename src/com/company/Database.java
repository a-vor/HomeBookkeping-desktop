package com.company;

import java.sql.*;

public class Database {
    Connection connection;
    private static final String url = "jdbc:sqlite:./database/db.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
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
