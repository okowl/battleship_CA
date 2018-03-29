package com.company;

public class game {

    int number_players;
    //creating an instance to make my utility methods accessible here
    utility u = new utility();
    //creating an instance to make my players methods accessible here
    player p = new player();
    //checking number of utility for program

    void menu(){
        //here we are getting how many players will play this time
        String number = "";
        u.print("\nHow many utility do we have today?\nMin = 1, max = 4");
        //validation is here
        number = u.validation("[1-4]+", "!!!!!! Please enter just a numbers from 1 to 4 !!!!!!");
        number_players = Integer.parseInt(number);

        //now creating players using player class
        int numberOfPlayers = 1; // you can use br.readLine for storing value here



    }



}
