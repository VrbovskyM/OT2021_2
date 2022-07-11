package com.company.listeners;

import com.company.car.Car;
import com.company.components.Config;
import com.company.components.PaintPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyMouseListener implements MouseListener, MouseMotionListener {
    private Config config;
    private ArrayList<Car> cars;
    private PaintPanel panel;
    private Car carToMove;
    private int x, y;
    public MyMouseListener(PaintPanel panel,Config config, ArrayList<Car> cars) {
        this.config = config;
        this.cars = cars;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (config.isModeCar()) {
            config.setCanChangeSize(true);
            System.out.println(config.getCurrenColor());
            cars.add(new Car(e.getX(), e.getY(), config.getCurrenColor()));
            panel.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!config.isModeDrag()) return;
        int dx = e.getX();
        int dy = e.getY();
        carToMove.setArcX(dx - x);
        carToMove.setStartX(dx - x);
        carToMove.setArcY(dy - y);
        carToMove.setStartY(dy -y);
        panel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (checkObject(e.getX(), e.getY()) != null && config.isModeDrag()) {
            carToMove = checkObject(e.getX(), e.getY());
            x = e.getX() - carToMove.getArcX();
            y = e.getY() - carToMove.getArcY();
        }
    }
    public Car checkObject(int x, int y) {
        for (Car car : cars) {
            Rectangle r = new Rectangle(car.getOval1X(), car.getArcY(), car.getOvalWidth()*3, car.getOvalHeight()*2);
            if (r.contains(x, y)){
                System.out.println(car);
                return car;
            }
        }
        return null;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
