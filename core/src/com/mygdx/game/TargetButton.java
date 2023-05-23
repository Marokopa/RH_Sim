package com.mygdx.game;

public class TargetButton {
    float x, y;
    float width, height;

    public TargetButton(float x, float y, float size){
        width = height = size;
        this.x = x;
        this.y = y;
    }

    boolean hit(float tx, float ty){
        if(x < tx && tx < x+width && y < ty && ty < y+height){
            return true;
        }
        return false;
    }
}
