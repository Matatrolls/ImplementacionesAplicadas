package com.integradora;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
    public abstract class Wall {
        protected double x;
        protected double y;
        protected double width;
        protected double height;

        public Wall(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        public double getX(){
            return x;
        }
        public double getY(){
            return y;
        }

        public abstract void draw(GraphicsContext gc);
}

