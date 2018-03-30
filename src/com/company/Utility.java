package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utility {


    //method for validation that reads user input and process it to validation
    public String read_from_keyboard(){
        String text = "";
        //try catch block for input reading to catch any mistakes
        //if this method will not work and print a specific mistake for support department
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            text = br.readLine();
        }catch(Exception e){
            print("001. Something went wrong");
        }
        return text;
    }

    //method that validate everything from tech point of view e.g. if you asking age, you cant insert any letters
    //it returns a right input to original method
    public String validation (String regex, String Error){
        boolean valid;
        String txt;

        //just a loop to repeat inserting until result is correct (user inserted just a numbers)
        //got text from reading keyboard method and checks it
        do{
            txt = read_from_keyboard();
            if(!txt.matches(regex)){
                valid = false;
                System.out.println(Error);

            }else{
                valid = true;
            }
        }while(!valid);

        return txt;
    }

    //method that printing stuff because I don't want to do System.out.println
    public void print(Object... something){
        //loop for printing and adding comas where it's needed
       for (int i = 0; i< something.length; i++){
            if(i == something.length-1){
                System.out.println(something[i]);
            }else{
                System.out.print(something[i] + ", ");
            }
        }

    }

    //method to print board with extra spaces between columns
    public void print_board(String [][] board, int x, int y){
        //printing loop
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                System.out.print(board[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }

}

