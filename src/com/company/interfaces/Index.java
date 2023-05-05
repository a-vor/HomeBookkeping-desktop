package com.company.interfaces;

import com.company.interfaces.components.ActionsMenu;
import com.company.interfaces.components.ScoresPanel;
import com.company.interfaces.components.TopMenu;
import com.company.interfaces.services.Auth;
import com.company.interfaces.services.Registration;
import com.company.models.User;

import javax.swing.*;
import java.awt.*;

public class Index extends JFrame {
    private ScoresPanel scoresPanel;
    public Index() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setJMenuBar(new TopMenu());
        scoresPanel = new ScoresPanel();
        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        getContentPane().setLayout(layout);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        getContentPane().add(new ActionsMenu());
        getContentPane().add(scoresPanel);
        setDefaultSettings();

    }

    private void setDefaultSettings() {
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void getScoresTable() {

//        setContentPane(contentPane); //
    }
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenu addIncome = new JMenu("Income");
        JMenuItem addOneTimeCharge = new JMenuItem("Разовый расход");
        JMenuItem addPeriodicCharge = new JMenuItem("Периодический расход расход");
        exitItem.addActionListener((event) -> System.exit(0)); // обработка события выхода из приложения
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
//        pack();
        addIncome.add(addOneTimeCharge);
        addIncome.add(addPeriodicCharge);

        menuBar.add(fileMenu);
        menuBar.add(addIncome);
//        this.setJMenuBar(menuBar); // добавление меню на фрейм
    }
    public static void main(String[] args) {
        Auth authFrame = new Auth();
        User user = waitingAuth(authFrame);
        Index index = new Index();
        System.out.println(user.toString());
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