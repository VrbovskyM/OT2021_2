package com.company.components;

import com.company.car.Car;
import com.company.listeners.MyKeyListener;
import com.company.listeners.MyMouseListener;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
@Data
public class PaintPanel extends JPanel {
    private ArrayList<Car> cars;
    private Config config;
    public PaintPanel(Config config) {
        setFocusable(true);
        cars = new ArrayList<>();
        this.config = config;
        MyMouseListener mouseListener = new MyMouseListener(this, config, cars);
        MyKeyListener keyListener = new MyKeyListener(this, config, cars);
        addKeyListener(keyListener);
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars) {
            car.drawCar(g);
        }
    }
}
