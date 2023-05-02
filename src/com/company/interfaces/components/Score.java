package com.company.interfaces.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    private final JTextField title;
    private final JTextField sum;
    private final JButton confirm;

    public Score() {
        this.title = new JTextField(20);
        this.sum = new JTextField(20);
        this.confirm = new JButton("Подтвердить");
        JPanel panel = new JPanel();
        panel.add(title);
        panel.add(sum);
        panel.add(confirm);
        panel.setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        getContentPane().add(panel);
        setTitle("Добавить счет");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Score();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
