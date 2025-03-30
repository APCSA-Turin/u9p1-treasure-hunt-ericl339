package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    // instance variables
    private int treasureCount;
    private int numLives;
    private boolean win;

    // creates the player with its x and y as well as setting treasure to 0 and lives to 2
    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x,y);
        treasureCount = 0;
        numLives = 2;
    }


    // gets the treasure count, number of lives, and win status
    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}


  
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

    // interact with another object that its moving to
    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
        // if the object is specifically a treasure and not a trophy then treasure count goes up
        if (obj instanceof Treasure && !(obj instanceof Trophy)) {
            treasureCount ++;
        }
        // if the object is a trophy and treasure count matches the amount of treasure given then win is true
        if (obj instanceof Trophy && treasureCount == numTreasures) {
            win = true;
        }
        // if the object is an enemy then lives goes down by 1
        if (obj instanceof Enemy) {
            numLives --;
        }
    }


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

    // gets the coordinates of the player
    public String getCoords(){
        return "Player:" + super.getCoords();
    }

    // gets thew row col of the player
    public String getRowCol(int size){
        return "Player:" + super.getRowCol(size);
    }
   
}



