package com.integradora;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class IrromplibleWall extends Wall {
    private double x;
    private double y;
    private double width;
    private double height;

    public IrromplibleWall(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    @Override
    public void draw(GraphicsContext gc) {

    }


}
