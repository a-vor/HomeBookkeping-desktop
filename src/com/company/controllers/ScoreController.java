package com.company.controllers;

import com.company.Database;
import com.company.models.Score;
import com.company.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ScoreController{
    public static void createScore (Score score, User user) throws SQLException {
        System.out.println("вызвал score controller");
        Connection connection = new Database().getConnection();
        if (isExistScore(score.getTitle(), score.getUserId(), connection)) {
            System.out.println("существует");
            connection.close();
        } else {
            addScore(connection, score, user.getId());
            connection.close();
        }
    }

    private static void addScore(Connection connection, Score score, int userId) throws SQLException {
        String sql = "INSERT INTO Scores (title, sum, userId) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1,
                score.getTitle());
        stmt.setDouble(2,
                score.getSum());
        stmt.setInt(3,
                userId);
        stmt.executeUpdate();
    }

    private static boolean isExistScore (String title, int id, Connection connection) {
        String sql = "SELECT * FROM Scores WHERE Title = ? AND userId = ?";
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

    public static JTable getAllScores (User user) {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM scores");
            tableModel.setRowCount(0);
            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();
            for (int i = 1; i <= colCount; i++) {
                tableModel.addColumn(meta.getColumnName(i));
                System.out.println(meta.getColumnName(i));
            }
            while (rs.next()) {
                Object[] row = new Object[colCount];
                for (int i = 1; i <= colCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }
}
