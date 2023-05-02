package com.company.controllers;

import com.company.Database;
import com.company.models.Score;
import com.company.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreController{
    public static void createScore (Score score, User user) throws SQLException {
        System.out.println("вызвал score controller");
        Connection connection = new Database().getConnection();
        if (isExistScore(score.getTitle(), score.getUserId(), connection)) {
            System.out.println("существует");
            connection.close();
        } else {
            addScore(connection, score);
            connection.close();
        }
    }

    private static void addScore(Connection connection, Score score) {

    }

    private static boolean isExistScore (String title, int id, Connection connection) {
        String sql = "SELECT * FROM Scores WHERE title = ? AND userId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,
                    title);
            stmt.setInt(2,
                    id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            System.out.println("Нет соединения с базой данных");
            return false;
        }
        return false;
    }
}
