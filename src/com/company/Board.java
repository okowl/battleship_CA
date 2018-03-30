package com.company;
import java.util.Random;

public class Board {

    public Integer x;
    public Integer y;
    private String [][] my_board;
    Utility u = new Utility();
    //Game g = new Game();

    public void new_board(int x, int y){
        this.x = x;
        this.y = y;
        int i,j;

        //setting up 2D-array
        my_board = new String [x][y];


        //loop to fill board with ~ symbols
        for(i = 0 ; i < x; i++){
            for(j = 0 ; j < y; j++){
                my_board[i][j] = "~";
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

    }

    //setter for board
    public String[][] getMy_board() {
        return my_board;
    }

    public void place_ship(/*int number*/){

    }




}
