package com.company.interfaces.components;

import com.company.controllers.ScoreController;
import com.company.models.User;

import javax.swing.*;

public class ScoresPanel extends JPanel {
    User user;
    private JTable table;

    public ScoresPanel(User user) {
        this.user = user;
        table = ScoreController.getAllScores(user);
        add(table);
    }
}