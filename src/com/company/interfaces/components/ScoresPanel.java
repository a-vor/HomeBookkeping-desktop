package com.company.interfaces.components;

import com.company.controllers.ScoreController;
import com.company.models.Score;
import com.company.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoresPanel extends JPanel {
    User user;
    private JTable table;
    public ScoresPanel(User user){
        this.user = user;
        System.out.println("Из scores Panel : " + user.toString());
        ResultSet resultSet = ScoreController.getAllScores(user);
//        Object[][] array = new Object[resultSet.size()][];
//        for (int i = 0; i < score.getResultList().size(); i++) {
//            array[i] = score.getResultList().get(i);
//        }

//        JTable table = new JTable(resultSet, new Object[] {"id", "title", "sum", "userId"});
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"N", "Cчет", "Баланс"}, 0);
        try {
            int number = 1;
            // Проходим по всем строкам resultSet, добавляя каждую строку в модель таблицы
            while (resultSet.next()) {
                Object[] row = {number, resultSet.getString("title"), resultSet.getInt("sum")};
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
}