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

    //extra credit
        // checks if the direction the player going to is valid
        public boolean isValid(int size, String direction){ //check grid boundaries
            // if the direction is w, checks to see the if row after moving is less than 0 and if so, return false
            if (direction.equals("w")) {
                if ((size - getY() - 1 - 1) < 0) {
                    return false;
                }
            }
            // if the direction is s, checks to see if row after moving is greater than the max row index + 1 and if so, return false
            if (direction.equals("s")) {
                if ((size - getY() - 1 + 1) > size - 1) {
                    return false;
                }
            }
            // if the direction is a, checks the col index of moving and if it is less than 0, return false
            if (direction.equals("a")) {
                if (getX() - 1 < 0) {
                    return false;
                }
            }
            // if the direction is d, checks the col index after moving and if it is greater than the max index + 1, then return false
            if (direction.equals("d")) {
                if (getX() + 1 > size - 1) {
                    return false;
                }
            }
            // returns true if all the tests passed
            return true;
        }
            //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
        // if the direction is w move coordinate up
        if (direction.equals("w")) {
            setY(getY() + 1);
        }
        // if the direction is s move ccoordinate down
        if (direction.equals("s")) {
            setY(getY() - 1);
        }
        // if the direction is a move the coordinate left
        if (direction.equals("a")) {
            setX(getX() - 1);
        }
        // if the direction is d move the coordinate right
        if (direction.equals("d")) {
            setX(getX() + 1);
        }
    }
}