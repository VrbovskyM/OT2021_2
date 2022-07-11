package com.company.components;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
@Data
public class Config {
    private boolean modeCar;
    private boolean modeDrag;
    private ArrayList<Color> colors;
    private Color currenColor;
    private boolean canChangeSize;
    public Config() {
        colors = new ArrayList<>();
        modeCar = true;
        modeDrag = false;
        addColors();
    }
    private void addColors() {
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.CYAN);
        setCurrenColor(colors.get(0));
    }
}
