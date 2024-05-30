package com.integradora;

import javafx.application.Platform;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;

public class Player {

    private Image playerImage;
    private double playerX = 50;
    private double playerY = 40;
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;


    private static String choice=PlayerSelectionView.getSelection();
    private boolean bombPressed;

    public String getchoice(){
        return choice;
    }

    public Player() {
        this.playerImage=new Image(choice+"IdleFront.png",50,50,true,true);
    }

    public void paint(boolean isRunning) throws FileNotFoundException {
        new Thread(() -> {
            while (isRunning) {
                Platform.runLater(this::updatePlayerPosition);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void updatePlayerPosition() {
        if (upPressed) {
            this.playerImage = new Image(choice +"WalkingBack.gif",50,50,true,true);
            playerY -= 5;
        }

        if (downPressed) {
            this.playerImage = new Image(choice +"WalkingFront.gif",50,50,true,true);
            playerY += 5;
        }
        if (leftPressed) {
            this.playerImage = new Image(choice +"WalkingLeft.gif",50,50,true,true);
            playerX -= 5;
        }
        if (rightPressed) {
            this.playerImage = new Image(choice +"WalkingRight.gif",50,50,true,true);
            playerX += 5;
        }

    }

    public double getPlayerX() {
        return playerX;
    }

    public void setPlayerX(double playerX) {
        this.playerX = playerX;
    }

    public double getPlayerY() {
        return playerY;
    }

    public void setPlayerY(double playerY) {
        this.playerY = playerY;
    }

    public Image getPlayerImage(){
        return playerImage;
    }

    public void setPlayerImage(Image playerImage) {
        this.playerImage = playerImage;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choicep) {
        choice = choicep;
    }

    public void setBombPressed(boolean bombPressed) {
        this.bombPressed = bombPressed;
    }

    public boolean isBombPressed() {
        return bombPressed;
    }
}
