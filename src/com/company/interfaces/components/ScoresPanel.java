package com.company.interfaces.components;

import com.company.controllers.ScoreController;
import com.company.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoresPanel extends JPanel {
    User user;
    private final JTable table;
    public ScoresPanel(User user){
        this.user = user;
        System.out.println("Из scores Panel : " + user.toString());
        ResultSet resultSet = ScoreController.getAllScores(user);
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"N", "Счет", "Баланс"}, 0);
        try {
            int number = 1;
            // Проходим по всем строкам resultSet, добавляя каждую строку в модель таблицы
            while (true) {
                assert resultSet != null;
                if (!resultSet.next()) break;
                Object[] row = {number, resultSet.getString("title"), resultSet.getDouble("sum") + " р."};
                tableModel.addRow(row);
                number++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        this.add(scrollPane);
    }

    public JTable getTable() {
        return table;
    }
}