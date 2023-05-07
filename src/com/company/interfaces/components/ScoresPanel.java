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
        Object[][] data = ScoreController.getAllScores(user);
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"N", "Cчет", "Баланс"}, 0);
        for (int i = 0; i < data.length; i++)
            tableModel.addRow(data[i]);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        this.add(scrollPane);

    }
}