package com.integradora;

import com.integradora.Wall;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DestructibleWall extends Wall {
    private boolean destroyed;

    public DestructibleWall(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.destroyed = false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (!destroyed) {
            gc.setFill(Color.GRAY); // Color de la pared destructible
            gc.fillRect(x, y, width, height);
        }
    }
    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }
}

