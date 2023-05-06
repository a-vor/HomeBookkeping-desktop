package com.company.interfaces.components;

import com.company.controllers.ScoreController;
import com.company.models.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class ScoresPanel extends JPanel{
    User user;
//    JPanel panel;
    public ScoresPanel (User user) throws SQLException {
        this.user = user;
        final int columnAmount = 4;
        ResultSet rs = ScoreController.getAllScores(user);
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        getColumnNames(metaData, columnNames);

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

    private void getColumnNames(ResultSetMetaData metaData, Vector<String> columnNames) throws SQLException {
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }
    }
}
