package com.company;
import java.util.Random;


public class Board {
    //initializing all values and parametrs
    public int x;
    public int y;
    private int size;
    private String [][] my_board;
    private String [] my_ship;
    private boolean horizon;
    Utility u = new Utility();

    //method to set up board
    void new_board(int x, int y){
        this.x = x;
        this.y = y;
        int i,j;

        //setting up 2D-array
        my_board = new String [x][y];


        //loop to fill board with - symbols
        for(i = 0 ; i < x; i++){
            for(j = 0 ; j < y; j++){
                my_board[i][j] = "-";
            }
        }
        //loop to fill first row of array with coordinates
        for(i = 0 ; i < x; i++){
            for(j = 0 ; j < y; j++){
                if(i == 0){
                my_board[i][0] = " ";//skipping (0, 0)
            } else {
                my_board[i][0] = String.valueOf(i);
                }
            }
        }
        //loop to fill first column of array with coordinates
        for(i = 0 ; i < x; i++){
            for(j = 0 ; j < y; j++){
                if(j == 0){
                    my_board[0][j] = " ";//skipping (0, 0)
                } else {
                    my_board[0][j] = String.valueOf(j);
                }
            }
        }
        place_ship();
    }

    //setting up ship, because it's only 1 ship I decided to store coordinates in the array of Strings, like a coordinates
    //in case if we need to have more than 2 ships it will be more efficient and more scalable to use two 2d arrays

    void place_ship() {

        this.size = Math.round(x / 3);//based on number of columns find a ship size
        this.horizon = new Random().nextBoolean();//randomizing horizontal or vertical layout of ship
        Random for_cord = new Random();
        int ship_x = for_cord.nextInt(x) + 1; //generating random point for x
        int ship_y = for_cord.nextInt(y) + 1; //generating random point for y

        my_ship = new String[size];//setting up an array
        //if random decided to place ship horizontal it will happen here
        if(horizon  == true){
            if(ship_x+size >= x){
                do{                     //moving x if ship cant fit in at this position
                   ship_x = ship_x - 1;
                } while(ship_x+size == x);
            }
            //loop to fill array with x coordinates
            for (int i = 0; i < size; i++){
                my_ship[i] = String.valueOf(ship_x+"," + ship_y);
                ship_x = ship_x + 1;

            }
        //if random decided to place ship vertical it will happen here
        } else {
            if(ship_y+size >= y){
                do{                     //moving y if ship cant fit in at this position
                    ship_y = ship_y - 1;
                } while(ship_y+size == y);
            }
            //loop to fill array with y coordinates
            for (int i = 0; i < size; i++){
                my_ship[i] = String.valueOf(ship_x+"," + ship_y);
                ship_y = ship_y + 1;

            }
        }

    }

    //setter for this board class
    public String[][] getMy_board() {
        return my_board;
    }
    public String[] getMy_ship(){
        return my_ship;
    }
    public int getSize(){
        return size;
    }

    //method that changes value at the board

    void change_my_board(String attempt, Boolean miss){
        int user_x, user_y;

        String[] parts = attempt.split(","); //splitting input to coordinates x and y
        user_x= Integer.parseInt(parts[0]); //split number for x and y to mark this coordinates at the board
        user_y = Integer.parseInt(parts[1]);

        if(miss == true){ //just changing the value at the position (x,y) on the board
            my_board[x][y] = "*"; //for miss
        } else {
            my_board[x][y] = "X"; //for hit
        }
    }



}
