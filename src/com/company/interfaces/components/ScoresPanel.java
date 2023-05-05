package com.company.interfaces.components;

import javax.swing.*;
import java.awt.*;

public class ScoresPanel extends JPanel{
//    JPanel panel;
    public ScoresPanel () {
//        panel = new JPanel();
        JTable table = new JTable(5, 6); // Создаем таблицу с 5 строками и 3 столбцами
        table.setPreferredScrollableViewportSize(new Dimension(700, table.getRowHeight() * 5));
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        JScrollPane scrollPane = new JScrollPane(table);
//        JPanel contentPane = new JPanel(); // Создаем панель содержимого
//        contentPane
        this.add(scrollPane); // Добавляем на панель содержимого панель со скроллом
    }
}
