package com.company.interfaces.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ScoresPanel extends JPanel{
//    JPanel panel;
    public ScoresPanel () {
        Object[][] data = {
                {"Иван", "Иванов", 25},
                {"Петр", "Петров", 30},
                {"Сидор", "Сидоров", 35}
        };
        final String[] columnNames = {"N", "Cчет", "Баланс"};
        JTable table = new JTable(data, columnNames); // Создаем таблицу с 5 строками и 3 столбцами
        table.setPreferredScrollableViewportSize(new Dimension(600, table.getRowHeight() * 5));
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel contentPane = new JPanel();
        contentPane.add(scrollPane);

        this.add(contentPane);
    }

}
