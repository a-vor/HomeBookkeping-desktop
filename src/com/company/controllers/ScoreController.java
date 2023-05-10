package com.company.controllers;

import com.company.Database;
import com.company.models.Score;
import com.company.models.User;
import java.sql.*;

public class ScoreController {
    public static void createScore (Score score, User user) throws SQLException {
        Connection connection = Database.getConnection();
        if (isExistScore(score.getTitle(), score.getUserId(), connection)) {
            connection.close();
        } else {
            addScore(connection, score, user.getId());
            connection.close();
        }
    }

    private static void addScore(Connection connection, Score score, int userId) throws SQLException {
        String sqlToScores = "INSERT INTO Scores (title, userId) VALUES (?, ?)";
        String sqlToBalances = "INSERT INTO Balances (scoreId, sum) VALUES (?, ?)";
        PreparedStatement stmtToScores = connection.prepareStatement(sqlToScores);
        PreparedStatement stmtToBalances = connection.prepareStatement(sqlToBalances);
        stmtToScores.setString(1,
                score.getTitle());
        stmtToScores.setInt(2,
                userId);
        stmtToScores.executeUpdate();
        ResultSet resultSet = stmtToScores.getGeneratedKeys();
        resultSet.next();
        stmtToBalances.setInt(1, resultSet.getInt(1));
        stmtToBalances.setDouble(2, score.getSum());
        stmtToBalances.executeUpdate();
    }

    private static boolean isExistScore (String title, int id, Connection connection) {
        String sql = "SELECT id FROM Scores WHERE title = ? AND userId = ?";
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

    public static ResultSet getAllScores (User user) {
        String sql = "SELECT Scores.title, Balances.sum FROM Scores\nJOIN Balances ON Scores.id = Balances.scoreId\nWHERE Scores.userId = ?";
        try {
            Connection connection = Database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}


