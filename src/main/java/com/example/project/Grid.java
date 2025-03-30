package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    // creates the instance variables
    private Sprite[][] grid;
    private int size;

    // creates a grid object
    public Grid(int size) { //initialize and create a grid with all DOT objects
        // initializes size
        this.size = size;
        // initializes grid
        grid = new Sprite[size][size];
        // iterates through the 2d array
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                // sets each index of grid equal to a new dot with the corresponding coordinates
                grid[row][col] = new Dot(col, size - row - 1);
            }
        }
    }

    // returns the size of the grid
    public int getSize() {
        return size;
    }

    // returns the grid itself
    public Sprite[][] getGrid(){return grid;}


    // places a sprite after coverting the x and y coordinates into row col
    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[(size - s.getY() - 1)][s.getX()] = s;
    }

    // places the price after a said direction
    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on 
        // if the direction is w
            if (direction.equals("w")) {
                // sets the grid corresponding to the x and y to the new sprite because this is after it has been moved
                grid[size - s.getY() - 1][s.getX()] = s;
                // sets a new dot object below the sprite to replace it
                grid[size - s.getY() - 1 + 1][s.getX()] = new Dot(s.getX(), s.getY());
            }
            if (direction.equals("s")) {
                // sets the grid corresponding to the x and y to the new sprite because this is after it has been moved
                grid[size - s.getY() - 1][s.getX()] = s;
                // sets a new dot object above the sprite to replace it
                grid[size - s.getY() - 1 - 1][s.getX()] = new Dot(s.getX(), s.getY());
            }
            if (direction.equals("a")) {
                // sets the grid corresponding to the x and y to the new sprite because this is after it has been moved
                grid[size - s.getY() - 1][s.getX()] = s;
                // sets a new dot object to the right of the sprite to replace it
                grid[size - s.getY() - 1][s.getX() + 1] = new Dot(s.getX(), s.getY());
            }
            if (direction.equals("d")) {
                // sets the grid corresponding to the x and y to the new sprite because this is after it has been moved
                grid[size - s.getY() - 1][s.getX()] = s;
                // sets a new dot object to the left of the sprite to replace it
                grid[size - s.getY() - 1][s.getX() - 1] = new Dot(s.getX(), s.getY());
            }
    }

    // displays the grid
    public void display() { //print out the current grid to the screen 
        // iterates through the row
        for (int row = 0; row < grid.length; row ++) {
            // iterates through the column
            for (int col = 0; col < grid[0].length; col ++) {
                // if the object is a dot print
                if (grid[row][col] instanceof Dot) {
                    System.out.print("⬜");
                }
                // if the object is a player print
                if (grid[row][col] instanceof Player) {
                    System.out.print("⬛");
                }
                // if the object is a trophy print
                if (grid[row][col] instanceof Trophy) {
                    System.out.print("🟧");
                }
                // if the object is a treasure print
                else if (grid[row][col] instanceof Treasure) {
                    System.out.print("🟨");
                }
                // if the object is an enemy print
                if (grid[row][col] instanceof Enemy) {
                    System.out.print("🟥");
                }
            }
            // line break
            System.out.println();
        }
    }
    
    // prints out a game over message
    public void gameover(){ //use this method to display a loss
        System.out.println("You lose!");
    }

    // prints out a game win message
    public void win(){ //use this method to display a win 
        System.out.println("You win!");
    }
}