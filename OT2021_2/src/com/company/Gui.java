package com.company;

import com.company.components.Config;
import com.company.components.MenuPanel;
import com.company.components.PaintPanel;

import javax.swing.*;
import java.awt.*;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();

        frame.setFocusable(false);
        Config config = new Config();
        frame.add("North",new MenuPanel(config));
        frame.add("Center", new PaintPanel(config));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(700,700));
        frame.setLocationRelativeTo(null);
    }
}
