package com.company.listeners;

import com.company.components.Config;
import com.company.components.MyLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private Config config;
    private MyLabel label;
    public MyActionListener(Config config, MyLabel label) {
        this.config = config;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Car":
                config.setModeCar(true);
                config.setModeDrag(false);
                label.setText("Car");
                break;
            case "Drag":
                config.setModeCar(false);
                config.setModeDrag(true);
                label.setText("Drag");
                break;
        }
    }
}
