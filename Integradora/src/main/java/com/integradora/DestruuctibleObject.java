package com.integradora;

import javafx.scene.image.Image;

public class DestruuctibleObject {
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public DestruuctibleObject(double x, double y, boolean isDestroyed, Image image) {
        this.x = x;
        this.y = y;
        this.isDestroyed = isDestroyed;
        this.image = image;
    }

    private double x;
    private double y;
    private boolean isDestroyed;

    private Image image;

    private double width;

    private  double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {

            return height;
    }
}
