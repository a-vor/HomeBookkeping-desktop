package com.company.interfaces;

import com.company.interfaces.components.ActionsMenu;
import com.company.interfaces.components.ScoreActions;
import com.company.interfaces.components.ScoresPanel;
import com.company.interfaces.components.TopMenu;
import com.company.interfaces.services.Auth;
import com.company.interfaces.services.Registration;
import com.company.models.User;

import javax.swing.*;
import java.awt.*;

public class Index extends JFrame {
    User user;
    private final ScoresPanel scoresPanel;
    public Index(User user){
        this.user = user;
        System.out.println(user.toString());
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setJMenuBar(new TopMenu());
        scoresPanel = new ScoresPanel(user);
        scoresPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        getContentPane().setLayout(layout);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        getContentPane().add(new ActionsMenu());
        getContentPane().add(scoresPanel);
        getContentPane().add(new ScoreActions(user));
        setDefaultSettings();
    }

    private void setDefaultSettings() {
        this.setTitle("Домашняя бухгалтерия | " + user.getName());
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Auth authFrame = new Auth();
        User user = waitingAuth(authFrame);
        new Index(user);
        System.out.println(user);
    }

    private static User waitingAuth(Auth authFrame) {
        User user = null;
        while (!authFrame.isAuth && !authFrame.isRegisterChange) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (authFrame.isAuth)
            user = authFrame.getUser();
        if (authFrame.isRegisterChange) {
            user = waitingRegistration(new Registration());
        }
        return user;
    }

    private static User waitingRegistration(Registration registrationFrame) {
        while (registrationFrame.getUser() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return registrationFrame.getUser();
    }
}