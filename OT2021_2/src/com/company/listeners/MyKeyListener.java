package com.company.listeners;

import com.company.car.Car;
import com.company.components.Config;
import com.company.components.PaintPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MyKeyListener implements KeyListener {
    private final Config config;
    private final ArrayList<Car> cars;
    private final PaintPanel panel;
    public MyKeyListener(PaintPanel panel, Config config, ArrayList<Car> cars) {
        this.config = config;
        this.cars = cars;
        this.panel = panel;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            config.setCanChangeSize(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && cars.size() > 0) {
            cars.remove(cars.size() - 1);
        }

        if(config.isModeCar() && cars.size() > 0 && config.isCanChangeSize()) {
            Car curCar = panel.getCars().get(cars.size() - 1);
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (curCar.getArcWidth() >= 10 && curCar.getArcX() >= curCar.getStartX()) {
                    curCar.setArcWidth(curCar.getArcWidth() - 10);
                }
                else{
                    curCar.setArcX(curCar.getArcX() - 10);
                    curCar.setArcWidth(curCar.getArcWidth() + 10);
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (curCar.getArcX() >= curCar.getStartX()) {
                    curCar.setArcWidth(curCar.getArcWidth() + 10);
                }
                else {
                    curCar.setArcX(curCar.getArcX() + 10);
                    curCar.setArcWidth(curCar.getArcWidth() - 10);
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (curCar.getArcHeight() >=10 && curCar.getArcY() >= curCar.getStartY()) {
                    curCar.setArcHeight(curCar.getArcHeight() - 10);
                }
                else {
                    curCar.setArcY(curCar.getArcY() - 10/4*3);
                    curCar.setArcHeight(curCar.getArcHeight() + 10);
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (curCar.getArcY() == curCar.getStartY()) {
                    curCar.setArcHeight(curCar.getArcHeight() + 10);
                }
                else {
                    curCar.setArcY(curCar.getArcY() + 10/4*3);
                    curCar.setArcHeight(curCar.getArcHeight() - 10);
                }
            }
        }
        panel.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
