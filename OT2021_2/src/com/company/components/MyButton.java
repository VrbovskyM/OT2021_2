package com.company.components;

import com.company.listeners.MyActionListener;

import javax.swing.*;

public class MyButton extends JButton {

    public MyButton(String label, MyActionListener myActionListener) {
        super(label);
        setFocusable(false);
        addActionListener(myActionListener);
    }
}
