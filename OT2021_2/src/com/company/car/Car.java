package com.company.car;

import lombok.Data;

import java.awt.*;
@Data
public class Car extends Rectangle {
    private Color c;
    private int startX, startY;
    private int arcX;
    private int arcY;
    private int arcHeight;
    private int arcWidth;
    private int oval1X, oval1Y, oval2X, oval2Y, ovalWidth, ovalHeight;
    public Car(int x, int y, Color c) {
        arcHeight = 60;
        arcWidth = 40;
        arcX = x;
        arcY = y;
        startX = x;
        startY = y;
        this.c = c;
        setCoords();
    }

    public void drawCar(Graphics g) {
        setCoords();
        g.setColor(c);
        g.fillOval(oval1X, oval1Y, ovalWidth, ovalHeight);
        g.fillOval(oval2X, oval2Y, ovalWidth, ovalHeight);
        g.fillArc(arcX, arcY, arcWidth,arcHeight, 0, 180);
    }
    private void setCoords() {
        ovalWidth = arcWidth / 2;
        ovalHeight = arcHeight / 3;
        oval1X = arcX - (arcWidth / 4);
        oval1Y = arcY + (arcHeight/2) - (ovalHeight/2);
        oval2X = arcX + (arcWidth /4*3);
        oval2Y = arcY + (arcHeight/2) - (ovalHeight/2);


    }
}
