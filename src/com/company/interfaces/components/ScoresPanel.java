package com.company.interfaces.components;

import com.company.controllers.ScoreController;
import com.company.models.User;

import javax.swing.*;

public class ScoresPanel extends JPanel {
    User user;
    public ScoresPanel(User user) {
        this.user = user;
        JTable table = ScoreController.getAllScores(user);
        add(table);
    }
}