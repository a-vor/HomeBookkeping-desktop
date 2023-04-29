package com.company.interfaces.services;

import com.company.controllers.UserController;
import com.company.middleware.PasswordCheck;
import com.company.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class Auth extends JFrame implements ActionListener {
    private User user;
    private JTextField loginField;
    private JTextField passwordField;
    private JButton registerButton;
    private JLabel registerLabel;
    public boolean isAuth = false;
    public boolean isRegisterChange = false;

    public Auth() {
        loginField = new JTextField(20);
        passwordField = new JTextField(20);
        registerButton = new JButton("Авторизация");
        registerButton.addActionListener(this);
        registerLabel = new JLabel("Регистрация");
        registerLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                isRegisterChange = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(loginField);
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(registerLabel);
        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setTitle("Авторизация");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    public User getUser() {
        return user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String login = loginField.getText().trim();
        final String password = passwordField.getText().trim();
        user = new User(login, password);
        user.setPassword(PasswordCheck.hashPassword(user.getPassword()));
        try {
            user = UserController.isValidUser(user);
            if (user == null) {
                JOptionPane.showMessageDialog(null, " Неверный логин или пароль", "Ошибка Авторизации", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.isAuth = true;
                dispose();
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
