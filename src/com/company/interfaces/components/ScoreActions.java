package com.company.interfaces.components;

import javax.swing.*;
import java.awt.*;

public class ScoreActions extends JPanel {
    public ScoreActions() {
        this.setLayout(new GridLayout(1, 6, 10, 0));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        JButton addScore = new JButton("Добавить");
        JButton renameScore = new JButton("Изменить");
        JButton delScore = new JButton("Удалить");

        this.add(addScore);
        this.add(renameScore);
        this.add(delScore);
    }
}
