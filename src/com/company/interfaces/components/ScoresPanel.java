package com.company.interfaces.components;

import com.company.controllers.ScoreController;
import com.company.models.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoresPanel extends JPanel{
    User user;
//    JPanel panel;
    public ScoresPanel (User user) throws SQLException {
        this.user = user;
        final int columnAmount = 4;
        ResultSet rs = ScoreController.getAllScores(user);
        Object [][] data = new Object[getRowsAmount(rs)][columnAmount];
        fillData(data, rs);
//        Object[][] data = {
//                {"Иван", "Иванов", 25, 11},
//                {"Петр", "Петров", 30, 11},
//                {"Сидор", "Сидоров", 35, 11}
//        };
        final String[] columnNames = {"Cчет", "Баланс", "Доход", "Расход"};
        JTable table = new JTable(data, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.setPreferredScrollableViewportSize(new Dimension(600, table.getRowHeight() * 5));
//        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        JScrollPane scrollPane = new JScrollPane(table);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        JPanel contentPane = new JPanel();
        contentPane.add(scrollPane);

        this.add(contentPane);
    }

    private int getRowsAmount(ResultSet rs) throws SQLException {
        rs.last();
        final int rowCount = rs.getRow();
        rs.first();
        return rowCount;
    }

    private void fillData(Object[][] data, ResultSet rs) throws SQLException {
        int i = 0;
        while(rs.next()) {
            data[i][0] = rs.getString("title");
            data[i][1] =
        }
    }
}
