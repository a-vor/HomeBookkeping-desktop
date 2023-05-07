package com.company.interfaces.components;

import com.company.controllers.ScoreController;
import com.company.controllers.UserController;
import com.company.models.Score;
import com.company.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ScoreFrame extends JFrame implements ActionListener {
    public User user;
    private final JTextField title;
    private final JTextField sum;
    private final JButton confirm;

    public ScoreFrame(User user) {
        this.user = user;
        this.title = new JTextField(20);
        this.sum = new JTextField(20);
        this.confirm = new JButton("Подтвердить");
        confirm.addActionListener(this);
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
        new ScoreFrame(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String titleText = title.getText();
        final double sumScore = Double.parseDouble(sum.getText());
        this.user = new User("1", "sdhjf");
        user.setId(15);
        Score score = new Score(sumScore, user.getId(), titleText);
        try {
            ScoreController.createScore(score, user);
            dispose();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
