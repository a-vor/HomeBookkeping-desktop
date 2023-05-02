package com.company.interfaces.components;
import com.company.models.User;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Income extends JFrame implements ActionListener {
    private User user;
    private final JTextField sumField;
    private final JDateChooser dateChooser;
    final private JButton confirmButton;
    final private JLabel addCategoryLabel;

    public Income(User user) {
        sumField = new JTextField(20);
        dateChooser = new JDateChooser(new Date());
        dateChooser.setPreferredSize(new Dimension(200, 20));
        JComboBox<String> comboBox = new JComboBox<>();
        confirmButton = new JButton("Подтвердить");
        confirmButton.addActionListener(this);
        addCategoryLabel = new JLabel("Добавить категорию");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(sumField);
        panel.add(dateChooser);
        panel.add(comboBox);
        panel.add(confirmButton);
        panel.add(addCategoryLabel);
        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setTitle("Добавить доход");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Income(null);
    }
}
