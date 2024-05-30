package com.integradora;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Bomb {
    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getInitialX() {
        return initialX;
    }

    public void setInitialX(double initialX) {
        this.initialX = initialX;
    }

    public double getInitialY() {
        return initialY;
    }

    public void setInitialY(double initialY) {
        this.initialY = initialY;
    }

    public double getDistanceMoved() {
        return distanceMoved;
    }

    public void setDistanceMoved(double distanceMoved) {
        this.distanceMoved = distanceMoved;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timeline getExplosionTimer() {
        return explosionTimer;
    }

    public void setExplosionTimer(Timeline explosionTimer) {
        this.explosionTimer = explosionTimer;
    }

    public Image getBombImage() {
        return bombImage;
    }

    public void setBombImage(Image bombImage) {
        this.bombImage = bombImage;
    }

    private double positionX;
    private double positionY;
    private double initialX;
    private double initialY;
    private double distanceMoved;
    private double maxDistance;
    private boolean isActive;
    private Timeline explosionTimer;
    private Image bombImage;

    public Bomb(double x, double y, Image bombImage, double durationInSeconds) {
        this.positionX = x;
        this.positionY = y;
        this.initialX = x;
        this.initialY = y;
        this.bombImage = bombImage;
        this.isActive = true;
        this.distanceMoved = 0;

        // Configuración del temporizador para la explosión de la bomba
        this.explosionTimer = new Timeline(new KeyFrame(Duration.seconds(durationInSeconds), event -> {
            this.isActive = false;
            // Lógica adicional al explotar la bomba, como eliminarla del canvas
        }));
        this.explosionTimer.setCycleCount(1);
        this.explosionTimer.play();
    }

    public boolean isActive() {
        return isActive;
    }

    public void paint(GraphicsContext gc) {
        if (isActive) {
            gc.drawImage(bombImage, positionX, positionY);
        }
    }

    public void move() {
        // Mueve la bomba una unidad a la derecha (puedes ajustar la dirección y la cantidad)
        this.positionX += 1;
        this.distanceMoved += 1;

        // Si la bomba ha alcanzado la distancia máxima, la desactivamos
        if (this.distanceMoved >= this.maxDistance) {
            this.isActive = false;
        }
    }

    public void reset() {
        this.positionX = initialX;
        this.positionY = initialY;
        this.distanceMoved = 0;
        this.isActive = true; // Asegúrate de activar la bomba al reiniciarla
    }

    // Getters y setters para otras propiedades si es necesario
}
