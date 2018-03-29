package com.company;
import java.util.ArrayList;

public class Game {

    //global variables for all objects
    ArrayList <Player> p_list = new ArrayList<>();
    private int number_players;
    //creating an instance to make my Utility methods accessible here
    Utility u = new Utility();



    //here is method that starts the Game and asks how many players will play it
    void start(){
        //here we are getting how many players will play this time
        String number = "";
        u.print("\nHow many players do we have today?\nMin = 1, max = 4");
        //validation is here
        number = u.validation("[1-4]+", "!!!!!! Please enter just a numbers from 1 to 4 !!!!!!");
        number_players = Integer.parseInt(number);
        Players();
    }

    //this method are filling all players data into array of objects
    void Players(){
        int counter = 0;
        int print = 1;
        //loop to fill the data from players to players array object
        do{
            //creating an instance to make my players methods accessible here
            Player p = new Player();
            u.print("Player "+print+" now it is your tern");
            p.get_info();
            int age = p.getAge();

            //validation of under age/over age players
            //if players age ok add new Player object into array list
            if((age > 11) && (age < 99)){

                p_list.add(p);
                counter++; print++;

                //if no let user to replace player or restart from beginning
            } else {
                u.print("Players should be older than 12 or younger than 99. Sorry.\n\nPress 1 if you can replace Player and continue" +
                        "\nPress 2 if you want to change number of players");
                String restart = u.validation("[1-2]", "Please just use numbers 1 or 2");

                if(restart.equals("2")){
                    start();
                }
            }

        }
        while (counter != number_players);

        //u.print(p_list.get(0).getAge());
        //u.print(p_list.get(1).getAge());
    }

}