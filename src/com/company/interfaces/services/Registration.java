package com.company.interfaces.services;

import com.company.controllers.UserController;
import com.company.middleware.PasswordCheck;
import com.company.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Registration extends JFrame implements ActionListener {
    final private JTextField loginField;
    private final JTextField nameField;
    private final JTextField passwordField;
    private final JButton registerButton;

    private User user = null;
    public Registration() {
        loginField = new JTextField(20);
        nameField = new JTextField(20);
        passwordField = new JTextField(20);
        registerButton = new JButton("Зарегистрироваться");
        registerButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(loginField);
        panel.add(nameField);
        panel.add(passwordField);
        panel.add(registerButton);

        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setTitle("Регистрация");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String login = loginField.getText().trim();
        final String name = nameField.getText().trim();
        final String password = passwordField.getText().trim();
        if (PasswordCheck.isValidParams(login, name, password)) {
            try {
                this.user = UserController.createUser(new User(login, name, PasswordCheck.hashPassword(password)));
                dispose();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public User getUser() {
        return user;
    }
}
