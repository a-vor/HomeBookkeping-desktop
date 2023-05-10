package com.company.interfaces.components;

import com.company.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreActions extends JPanel implements ActionListener {
    User user;
    JTable scoresTable;
    private final JButton addScore;
    private final JButton renameScore;
    private final JButton delScore;
    public ScoreActions(User user, JTable table) {
        this.user = user;
        this.scoresTable = table;
        this.setLayout(new GridLayout(1, 6, 10, 0));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        addScore = new JButton("Добавить");
        renameScore = new JButton("Изменить");
        delScore = new JButton("Удалить");
        addScore.addActionListener(this);
        renameScore.addActionListener(this);
        delScore.addActionListener(this);
        this.add(addScore);
        this.add(renameScore);
        this.add(delScore);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addScore) {
            new ScoreFrame(user, scoresTable);
        }
        if (e.getSource() == renameScore) {
            System.out.println("renameScore");
        }
        if (e.getSource() == delScore) {
            System.out.println("deleteScore");
        }
    }
}
