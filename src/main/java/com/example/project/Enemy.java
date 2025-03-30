package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite{ //child  of Sprite
    
    //creates the enemy object with its coordinates
    public Enemy(int x, int y) {
        super(x,y);
    }


    //the methods below should override the super class 

    // returns the coordinates
    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Enemy:" + super.getCoords();
    }

    // returns the rowcol
    public String getRowCol(int size){ //return "Enemy:"+row col
        return "Enemy:" + super.getRowCol(size);
    }
}