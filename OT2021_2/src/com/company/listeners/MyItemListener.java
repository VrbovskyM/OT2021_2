package com.company.listeners;

import com.company.components.Config;
import com.company.components.MyComboBox;
import com.company.components.MyLabel;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;

public class MyItemListener implements ItemListener {
    private Config config;
    private MyLabel label;
    public MyItemListener(Config config, MyLabel label) {
        this.config = config;
        this.label = label;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        MyComboBox cb = (MyComboBox) e.getSource();
        String selectedItem = (String) cb.getSelectedItem();
        try {
            Field f = Color.class.getField(selectedItem);
            Color color = (Color)f.get(null);
            label.setBackground(color);
            config.setCurrenColor(color);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
