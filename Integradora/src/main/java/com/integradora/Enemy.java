package com.integradora;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy {
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    private float x;
    private float y;
    private float startX;

    private float startY;
    private float speed;
    private Image imagen;

    public Enemy(float x, float y) {
        this.x = x;
        this.y = y;
        this.startX=x;
        this.startY=y;
        this.speed = 1;

        this.imagen = new Image("EnemyWalk.gif");
    }

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public void setImagen(Image newImagen) {
        this.imagen=newImagen;
    }

    public Image getImagen() {
        return imagen;
    }
}
