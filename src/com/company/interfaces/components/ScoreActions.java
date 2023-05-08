package com.company.interfaces.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreActions extends JPanel implements ActionListener {
    private JButton addScore;
    private JButton renameScore;
    private JButton delScore;
    public ScoreActions() {
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
            System.out.println("addScore");
        }
        if (e.getSource() == addScore) {
            System.out.println("renameScore");
        }
        if (e.getSource() == addScore) {
            System.out.println("deleteScore");
        }
    }
}
