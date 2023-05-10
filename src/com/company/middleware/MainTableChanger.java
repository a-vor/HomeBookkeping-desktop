package com.company.middleware;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainTableChanger {
    public static void addScoreRow(JTable table, String title, double money) {
        Object[] newScore = {table.getRowCount() + 1, title, money + " р."};
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(newScore);
    }
}
