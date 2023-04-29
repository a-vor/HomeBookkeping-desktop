package com.company.interfaces;

import com.company.models.User;

import javax.swing.*;

public class Index extends JFrame {
    public Index() {
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

        addIncome.add(addOneTimeCharge);
        addIncome.add(addPeriodicCharge);

        menuBar.add(fileMenu);
        menuBar.add(addIncome);
        setJMenuBar(menuBar); // добавление меню на фрейм
        setLocationRelativeTo(null);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        Auth authFrame = new Auth();
        User user = null;
        user = waitingAuth(authFrame);
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
        User user = null;
        while (registrationFrame.getUser() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        user = registrationFrame.getUser();
        return user;
    }
}