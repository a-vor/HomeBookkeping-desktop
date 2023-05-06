package com.company.interfaces.components;

import com.company.controllers.ScoreController;
import com.company.models.Score;
import com.company.models.User;

import javax.swing.*;
import java.sql.SQLException;

public class ScoresPanel extends JPanel {
    User user;
    public ScoresPanel(User user){
        this.user = user;
        System.out.println("Из scores Panel : " + user.toString());
        Score score = ScoreController.getAllScores(user);
    }
}