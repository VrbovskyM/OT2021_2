package com.company.components;

import com.company.listeners.MyActionListener;
import com.company.listeners.MyItemListener;

import javax.swing.*;

public class MyComboBox extends JComboBox<String> {

    public MyComboBox(MyItemListener myItemListener) {
        super(new String[] {"RED", "ORANGE", "CYAN"});
        setFocusable(false);
        addItemListener(myItemListener);
    }
}
