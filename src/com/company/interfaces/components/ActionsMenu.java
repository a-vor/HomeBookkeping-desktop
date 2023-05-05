package com.company.interfaces.components;

import javax.swing.*;
import java.awt.*;

public class ActionsMenu extends JPanel {
    public ActionsMenu() {
        this.setLayout(new GridLayout(1, 4, 10, 0));;
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        JButton getScores = new JButton("Счета");
        JButton getIncomes = new JButton("Доходы");
        JButton getConsuption = new JButton("Расходы");
        JButton planning = new JButton("Планирование");
        this.add(getScores);
        this.add(getIncomes);
        this.add(getConsuption);
        this.add(planning);
    }
}
