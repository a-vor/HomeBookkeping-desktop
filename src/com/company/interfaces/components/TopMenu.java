package com.company.interfaces.components;

import javax.swing.*;

public class TopMenu extends JMenuBar {
    public TopMenu () {
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

        this.add(fileMenu);
        this.add(addIncome);
    }
}
