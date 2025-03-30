package com.example.project;
import java.util.Scanner;
import java.util.*;

public class Game{
    // creates the variable
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    // contructor
    public Game(int size){ //the constructor should call initialize() and play()
        // initializzes size
        this.size = size;
        // calls initalize and play
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // game logic
    public void play(){ //write your game logic here
        // creates the scanner object
        Scanner scanner = new Scanner(System.in);
        // runs the game
        while(true){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop

            // displays the grid
            grid.display();
            // displays the hud
            System.out.println(player.getCoords());
            System.out.println(player.getRowCol(size));
            System.out.println("Treasure collected: " + player.getTreasureCount());
            System.out.println("Lives remaining: " + player.getLives());
            // asks the user for a direction to move to
            System.out.println("Enter a direction(w,a,s,d) or q to exit: ");
            // sets the string to direction
            String direction = scanner.nextLine();
            // if the user writes q, then quit the for loop and the game
            if (direction.equals("q")) {
                break;
            }
            // else continue
            else {
                // EXTRA CREDIT 
                // creates a way variable to determine if enemies will move horizontally or vertically. sets it to 0 or 1
                int way = (int)(Math.random() * (1 - 0 + 1)) + 0;
                // if horizontally
                if (way == 0 ){
                    // if the enemy isnt on the same x as player then run
                    if (!(enemies[0].getX() == player.getX())) {
                        // if enemy is farther right than player run
                        if (enemies[0].getX() > player.getX()) {
                            // checks for collision and makes sure not to bump into them
                            if (!(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() - 1] instanceof Treasure && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() - 1] instanceof Trophy)) && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() - 1] instanceof Trophy) && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() - 1] instanceof Enemy)) {
                                // moves the enemy to the left
                                enemies[0].move("a");
                                grid.placeSprite(enemies[0],"a");
                            }
                        }
                        // if the enemy is farther left than the player run
                        else {
                            // checks for collision and makes sure not to bump into them
                            if (!(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() + 1] instanceof Treasure && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() + 1] instanceof Trophy)) && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() + 1] instanceof Trophy) && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() + 1] instanceof Enemy)) {
                                // moves the enemy to the right
                                enemies[0].move("d");
                                grid.placeSprite(enemies[0],"d");
                            }   
                        }
                    }
                    // if the enemy is on the same x, then move vertically. checks also if the enemy is on the same y value
                    else if (!(enemies[0].getY() == player.getY())){
                        // if the enemy is further up then run
                        if (enemies[0].getY() > player.getY()) {
                            // checks for collision so that it doesnt replace any sprite
                            if (!(grid.getGrid()[size - enemies[0].getY() - 1 + 1][enemies[0].getX()] instanceof Treasure && !(grid.getGrid()[size - enemies[0].getY() - 1 + 1][enemies[0].getX()] instanceof Trophy)) && !(grid.getGrid()[size - enemies[0].getY() - 1 + 1][enemies[0].getX()] instanceof Trophy) && !(grid.getGrid()[size - enemies[0].getY() - 1 + 1][enemies[0].getX()] instanceof Enemy)) {
                                // moves the enemy down
                                enemies[0].move("s");
                                grid.placeSprite(enemies[0],"s");
                            }
                        }
                        // if the enemy is lower than player
                        else {
                            // checks for collision
                            if (!(grid.getGrid()[size - enemies[0].getY() - 1 - 1][enemies[0].getX()] instanceof Treasure && !(grid.getGrid()[size - enemies[0].getY() - 1 - 1][enemies[0].getX()] instanceof Trophy)) && !(grid.getGrid()[size - enemies[0].getY() - 1 - 1][enemies[0].getX()] instanceof Trophy) && !(grid.getGrid()[size - enemies[0].getY() - 1 - 1][enemies[0].getX()] instanceof Enemy)) {
                                // moves the enemy up
                                enemies[0].move("w");
                                grid.placeSprite(enemies[0],"w");
                            }   
                        }
                    }
                }
                // runs if vertically comes first
                else if (way == 1){
                    // runs if the enemy isnt on the same y axis
                    if (!(enemies[0].getY() == player.getY())){
                        // runs if the enemy is higher than player
                        if (enemies[0].getY() > player.getY()) {
                            // checks collisions
                            if (!(grid.getGrid()[size - enemies[0].getY() - 1 + 1][enemies[0].getX()] instanceof Treasure && !(grid.getGrid()[size - enemies[0].getY() - 1 + 1][enemies[0].getX()] instanceof Trophy)) && !(grid.getGrid()[size - enemies[0].getY() - 1 + 1][enemies[0].getX()] instanceof Trophy) && !(grid.getGrid()[size - enemies[0].getY() - 1 + 1][enemies[0].getX()] instanceof Enemy)) {
                                // moves the enemy down
                                enemies[0].move("s");
                                grid.placeSprite(enemies[0],"s");
                            }
                        }
                        // runs if the enemy is lower than player
                        else {
                            // checks for collision
                            if (!(grid.getGrid()[size - enemies[0].getY() - 1 - 1][enemies[0].getX()] instanceof Treasure && !(grid.getGrid()[size - enemies[0].getY() - 1 - 1][enemies[0].getX()] instanceof Trophy)) && !(grid.getGrid()[size - enemies[0].getY() - 1 - 1][enemies[0].getX()] instanceof Trophy) && !(grid.getGrid()[size - enemies[0].getY() - 1 - 1][enemies[0].getX()] instanceof Enemy)) {
                                // moves the enemy up
                                enemies[0].move("w");
                                grid.placeSprite(enemies[0],"w");
                            }   
                        }
                    }
                    // runs if the enemy is on the same y axis as player
                    else if (!(enemies[0].getX() == player.getX())) {
                        // runs if the enemy is to the right
                        if (enemies[0].getX() > player.getX()) {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() - 1] instanceof Treasure && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() - 1] instanceof Trophy)) && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() - 1] instanceof Trophy) && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() - 1] instanceof Enemy)) {
                                // moves the enemy to the left
                                enemies[0].move("a");
                                grid.placeSprite(enemies[0],"a");
                            }
                        }
                        // runs if the enemy is to the left
                        else {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() + 1] instanceof Treasure && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() + 1] instanceof Trophy)) && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() + 1] instanceof Trophy) && !(grid.getGrid()[size - enemies[0].getY() - 1][enemies[0].getX() + 1] instanceof Enemy)) {
                                // moves the enemy to the right
                                enemies[0].move("d");
                                grid.placeSprite(enemies[0],"d");
                            }   
                        }
                    }
                }

                // makes another random seletor for the second enemy
                int way2 = (int)(Math.random() * (1 - 0 + 1)) + 0;
                // runs if horizontal is first
                if (way2 == 0 ){
                    // checks if the enemy is not on the same x axis
                    if (!(enemies[1].getX() == player.getX())) {
                        // runs if the enemy is to the right
                        if (enemies[1].getX() > player.getX()) {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() - 1] instanceof Treasure && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() - 1] instanceof Trophy)) && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() - 1] instanceof Trophy) && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() - 1] instanceof Enemy)) {
                                // moves the enemy to the left
                                enemies[1].move("a");
                                grid.placeSprite(enemies[1],"a");
                            }
                        }
                        // runs if the enemy is to the left
                        else {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() + 1] instanceof Treasure && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() + 1] instanceof Trophy)) && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() + 1] instanceof Trophy) && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() + 1] instanceof Enemy)) {
                                // runs the enemy to the right
                                enemies[1].move("d");
                                grid.placeSprite(enemies[1],"d");
                            }   
                        }
                    }
                    // runs if the enemy is on the same x axis
                    else if (!(enemies[1].getY() == player.getY())){
                        // runs if the enemy is higher
                        if (enemies[1].getY() > player.getY()) {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[1].getY() - 1 + 1][enemies[1].getX()] instanceof Treasure && !(grid.getGrid()[size - enemies[1].getY() - 1 + 1][enemies[1].getX()] instanceof Trophy)) && !(grid.getGrid()[size - enemies[1].getY() - 1 + 1][enemies[1].getX()] instanceof Trophy) && !(grid.getGrid()[size - enemies[1].getY() - 1 + 1][enemies[1].getX()] instanceof Enemy)) {
                                // moves the enemy down
                                enemies[1].move("s");
                                grid.placeSprite(enemies[1],"s");
                            }
                        }
                        // runs if the enemy is lower
                        else {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[1].getY() - 1 - 1][enemies[1].getX()] instanceof Treasure && !(grid.getGrid()[size - enemies[1].getY() - 1 - 1][enemies[1].getX()] instanceof Trophy)) && !(grid.getGrid()[size - enemies[1].getY() - 1 - 1][enemies[1].getX()] instanceof Trophy) && !(grid.getGrid()[size - enemies[1].getY() - 1 - 1][enemies[1].getX()] instanceof Enemy)) {
                                // moves the enemy up
                                enemies[1].move("w");
                                grid.placeSprite(enemies[1],"w");
                            }   
                        }
                    }
                }
                // runs for verticle first
                else if (way == 1){
                    // checks if the enemy is not on the same y axis
                    if (!(enemies[1].getY() == player.getY())){
                        // runs if enemy is higher
                        if (enemies[1].getY() > player.getY()) {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[1].getY() - 1 + 1][enemies[1].getX()] instanceof Treasure && !(grid.getGrid()[size - enemies[1].getY() - 1 + 1][enemies[1].getX()] instanceof Trophy)) && !(grid.getGrid()[size - enemies[1].getY() - 1 + 1][enemies[1].getX()] instanceof Trophy) && !(grid.getGrid()[size - enemies[1].getY() - 1 + 1][enemies[1].getX()] instanceof Enemy)) {
                                // moves enemy down
                                enemies[1].move("s");
                                grid.placeSprite(enemies[1],"s");
                            }
                        }
                        // runs if enemy is lower
                        else {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[1].getY() - 1 - 1][enemies[1].getX()] instanceof Treasure && !(grid.getGrid()[size - enemies[1].getY() - 1 - 1][enemies[1].getX()] instanceof Trophy)) && !(grid.getGrid()[size - enemies[1].getY() - 1 - 1][enemies[1].getX()] instanceof Trophy) && !(grid.getGrid()[size - enemies[1].getY() - 1 - 1][enemies[1].getX()] instanceof Enemy)) {
                                // moves enemy up
                                enemies[1].move("w");
                                grid.placeSprite(enemies[1],"w");
                            }   
                        }
                    }
                    // runs if the enemy is on the same y axis
                    else if (!(enemies[1].getX() == player.getX())) {
                        // runs if the enemy is to the right
                        if (enemies[1].getX() > player.getX()) {
                            // checks collsion
                            if (!(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() - 1] instanceof Treasure && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() - 1] instanceof Trophy)) && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() - 1] instanceof Trophy) && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() - 1] instanceof Enemy)) {
                                // moves the enemy to the left
                                enemies[1].move("a");
                                grid.placeSprite(enemies[1],"a");
                            }
                        }
                        // runs if the enemy is to the left
                        else {
                            // checks collision
                            if (!(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() + 1] instanceof Treasure && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() + 1] instanceof Trophy)) && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() + 1] instanceof Trophy) && !(grid.getGrid()[size - enemies[1].getY() - 1][enemies[1].getX() + 1] instanceof Enemy)) {
                                // moves the enemy to the right
                                enemies[1].move("d");
                                grid.placeSprite(enemies[1],"d");
                            }   
                        }
                    }
                }


                // checks to see if the direction is a valid direction
                if (player.isValid(size, direction)) {
                    // creates a go boolean to allow the player to move
                    boolean go = true;
                    // if the player moves up
                    if (direction.equals("w")) {
                        // checks to see if the object up is a trophy
                        if (grid.getGrid()[size - player.getY() - 1 - 1][player.getX()] instanceof Trophy) {
                            // if it is, then interacts with it
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1 - 1][player.getX()]);
                            // if the player doesnt have two treasures, then they wont move up. set go to false
                            if (player.getWin() == false) {
                                go = false;
                            }
                        }
                        // checks to see if the object is a treasure and if so, iteracts with it
                        else if (grid.getGrid()[size - player.getY() - 1 - 1][player.getX()] instanceof Treasure && !(grid.getGrid()[size - player.getY() - 1 - 1][player.getX()] instanceof Trophy)) {
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1 - 1][player.getX()]);
                        }
                        // checks to see if the object is an enemy and if so, interacts with it
                        else if (grid.getGrid()[size - player.getY() - 1 - 1][player.getX()] instanceof Enemy) {
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1 - 1][player.getX()]);
                        }
                    }
                    // if the player moves down
                    if (direction.equals("s")) {
                        // checks to see if the object down is a trophy
                        if (grid.getGrid()[size - player.getY() - 1 + 1][player.getX()] instanceof Trophy) {
                            // iteracts with it
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1 + 1][player.getX()]);
                            // if the player doesnt have two treasures then go is set to false and the player doesnt move down
                            if (player.getWin() == false) {
                                go = false;
                            }
                        }
                        // checks to see if the object down is a treasure and if so interact
                        else if (grid.getGrid()[size - player.getY() - 1 + 1][player.getX()] instanceof Treasure && !(grid.getGrid()[size - player.getY() - 1 + 1][player.getX()] instanceof Trophy)) {
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1 + 1][player.getX()]);
                        }
                        // checks to see if the object down is an enemy and if so interact
                        else if (grid.getGrid()[size - player.getY() - 1 + 1][player.getX()] instanceof Enemy) {
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1 + 1][player.getX()]);
                        }
                    }
                    // if the player moves to the left
                    if (direction.equals("a")) {
                        // checks to see if the object up is a trophy
                        if (grid.getGrid()[size - player.getY() - 1][player.getX() - 1] instanceof Trophy) {
                            // interacts with the trophy
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1][player.getX() - 1]);
                            // if the player does not have two treasures then set go to false and player stays
                            if (player.getWin() == false) {
                                go = false;
                            }
                        }
                        // if the object is a treasure then interact with it
                        else if (grid.getGrid()[size - player.getY() - 1][player.getX() - 1] instanceof Treasure && !(grid.getGrid()[size - player.getY() - 1][player.getX() - 1] instanceof Trophy)) {
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1][player.getX() - 1]);
                        }
                        // if the object is an enemy then interact with it
                        else if (grid.getGrid()[size - player.getY() - 1][player.getX() - 1] instanceof Enemy) {
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1][player.getX() - 1]);
                        }
                    }
                    // if the plaayer moves to the right
                    if (direction.equals("d")) {
                        // checks to see if the object to the right is a trophy
                        if (grid.getGrid()[size - player.getY() - 1][player.getX() + 1] instanceof Trophy) {
                            // iterates with it
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1][player.getX() +1]);
                            // if the player doesnt have two treasures then go is false and player doesnt move
                            if (player.getWin() == false) {
                                go = false;
                            }
                        }
                        // checks if the object is a treasure and interacts if so
                        else if (grid.getGrid()[size - player.getY() - 1][player.getX() + 1] instanceof Treasure && !(grid.getGrid()[size - player.getY() - 1][player.getX() + 1] instanceof Trophy)) {
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1][player.getX() + 1]);
                        }
                        // checks if the object is an enemy and interacts if so
                        else if (grid.getGrid()[size - player.getY() - 1][player.getX() + 1] instanceof Enemy) {
                            player.interact(size, direction, treasures.length, grid.getGrid()[size - player.getY() - 1][player.getX() + 1]);
                        }
                    }
                    // if the player is allowed to move, then move the player xy and place it on its new rowcol
                    if (go) {
                        player.move(direction);
                        grid.placeSprite(player,direction);
                    }
                    // if the player wins then break the loop
                    if (player.getWin()) {
                        break;
                    }
                    // if the player dies then break the loop
                    if (player.getLives() == 0) {
                        break;
                    }
                }
            }
        }
        // clears the screen
        clearScreen(); // Clear the screen at the beggining of the while loop
        // if the player wins
        if (player.getWin()) {
            // iterate through the grid
            for (int row = 0; row < grid.getGrid().length; row ++) {
                for (int col = 0; col < grid.getGrid()[0].length; col ++) {
                    // prints out a crown
                    System.out.print("👑");
                }
                //line break
                System.out.println();
            }
            // prints out the win statement
            grid.win();
        }
        // if the player loses
        if (player.getLives() == 0 ){
            // iterates through the grid
            for (int row = 0; row < grid.getGrid().length; row ++) {
                for (int col = 0; col < grid.getGrid()[0].length; col ++) {
                    // prints out skull emojis
                    System.out.print("💀");
                }
                //line break
                System.out.println();
            }
            // prints out a gameover statement
            grid.gameover();
        }
    }

    // initializes the variables
    public void initialize(){
        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        // creates a new grid based on the size
        grid = new Grid(size);

        // creates a player and palces it
        player = new Player(0, 0);
        grid.placeSprite(player);

        // creates two enemies and places it
        Enemy enemy = new Enemy(9, 8);
        grid.placeSprite(enemy);

        Enemy enemy2 = new Enemy(8,9);
        grid.placeSprite(enemy2);
        
        // makes an enemy list and places the enemy in the list
        enemies = new Enemy[2];
        enemies[0] = enemy;
        enemies[1] = enemy2;

        // creates two treasures and places them
        Treasure treasure = new Treasure(2, 7);
        grid.placeSprite(treasure);

        Treasure treasure2 = new Treasure(7,8);
        grid.placeSprite(treasure2);

        // creates a treasure list and places the treasures
        treasures = new Treasure[2];
        treasures[0] = treasure;
        treasures[1] = treasure2;

        // creates a trophy and places it on the grid
        trophy = new Trophy(9, 9);
        grid.placeSprite(trophy);
    }

    // runner
    public static void main(String[] args) {
        // creates a new game object and runs it
        Game game = new Game(10);
    }
}