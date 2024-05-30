package com.integradora;

public class Level {
    private boolean completed;
    public Level(){
        this.completed=false;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }
}
