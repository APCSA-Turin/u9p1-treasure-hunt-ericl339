package com.example.project;

public class Sprite {
    // instance variables
    private int x, y;

    // creates the sprite with its coordinates
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // returns the x and the y 
    public int getX(){return x;}
    public int getY(){return y;}


    // sets new x and y
    public void setX(int newX){x = newX;}
    public void setY(int newY){y = newY;}

    // returns the coordinates as string
    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "(" + x + "," + y + ")";
    }

    // returns the rowcol as strings
    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        // converts the x and y coordinates to row and col. x is col and row is the max index minus y
        return "[" + (size - y - 1) + "][" + x + "]";
    }
    

    // moves the string
    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    // interact with other objects
    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }



}
