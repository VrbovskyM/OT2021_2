package com.company.components;

import com.company.listeners.MyActionListener;
import com.company.listeners.MyItemListener;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(Config config) {
        setLayout(new GridLayout());
        MyLabel label = new MyLabel("Car", config);
        MyActionListener myActionListener = new MyActionListener(config, label);
        MyItemListener myItemListener = new MyItemListener(config, label);
        MyButton car = new MyButton("Car", myActionListener);
        MyButton drag = new MyButton("Drag", myActionListener);
        MyComboBox color = new MyComboBox(myItemListener);

        add(car);
        add(drag);
        add(color);
        add(label);
    }
}
