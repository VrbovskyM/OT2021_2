package com.company.components;

import javax.swing.*;

public class MyLabel extends JLabel {

    public MyLabel(String label, Config config) {
        super(label);
        setBackground(config.getColors().get(0));
        setFocusable(false);
        setOpaque(true);
    }
}
