package com.company.interfaces.components;

import com.company.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ScoresPanel extends JPanel {
    User user;
    private JTable table;
    private DefaultTableModel tableModel;

    public ScoresPanel(User user) {
        this.user = user;
        setLayout(new BorderLayout());

        // Создаем таблицу и добавляем ее на панель
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Получаем данные из БД и заполняем таблицу
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite: ../../database/db.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM scores");

            // Очищаем таблицу перед добавлением новых данных
            tableModel.setRowCount(0);

            // Получаем метаданные о результатах запроса
            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();

            // Добавляем имена столбцов в модель таблицы
            for (int i = 1; i <= colCount; i++) {
                tableModel.addColumn(meta.getColumnName(i));
            }

            // Добавляем данные в модель таблицы
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
    }
}