package com.company;
import java.util.ArrayList;
import java.util.Arrays;


public class Game {

    //global variables for all objects
    ArrayList <Player> p_list = new ArrayList<>();
    private int number_players;
    private int x, y;
    //creating an instance to make my Utility and board methods available in this class methods accessible here
    Utility u = new Utility();
    Board b = new Board();



    //here is method that starts the Game and asks how many players will play it
    void start(){
        //here we are getting how many players will play this time
        String number = "";
        u.print("\nHow many players do we have today?\nMin = 1, max = 4");
        //validation is here
        number = u.validation("[1-4]", "!!!!!! Please enter just a numbers from 1 to 4 !!!!!!");
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
            //int age = p.getAge();

            //validation of under age/over age players
            //if players age ok add new Player object into array list
            //if((age > 11) && (age < 99)){

                p_list.add(p);
                counter++; print++;

                //if no let user to replace player or restart from beginning
           /* } else {
                u.print("Players should be older than 12 or younger than 99. Sorry.\n\nPress 1 if you can replace Player and continue" +
                        "\nPress 2 if you want to change number of players");
                String restart = u.validation("[1-2]", "Please just use numbers 1 or 2");

                if(restart.equals("2")){
                    start();
                }
            }*/

        } while (counter != number_players);
        new_board();

        //u.print(p_list.get(0).getAge());

    }

    //method to get the size of the board from user and set up board
    void new_board(){

        u.print("Let set the board! You can make it at least 10 by 10, but maximum 20 by 20" +
                "\nHow many rows do you want?");
        String columns = u.validation("([1][0-9])|([2][0])", "Please use just numbers between 10 and 20");
        this.x = 1+Integer.parseInt(columns);

        u.print("How many columns do you want?");
        String rows = u.validation("([1][0-9])|([2][0])", "Please use just numbers between 10 and 20");
        this.y = 1+Integer.parseInt(rows);
        b.new_board(x, y);
        start_playing();
    }

    //method that actually starting the game itself
    void start_playing(){
        //initializing all parameters that game needs to process
        int hits_left = b.getSize();
        String attempt;
        boolean miss;
        Player p = new Player();

        u.print("Lets start the game! \n" );

        //loop that keeps game on while th
        do{
            //loop that switching terns between players
            for(int i = 0; i < number_players; i++){
                u.print_board(b.getMy_board(), x, y);
                u.print("\nIt's "+p_list.get(i).getName()+ "turn! \n");

                    attempt = valid_coordinates(); //get valid coordinates that wasn't used before

                if(is_it_hit(attempt) == true){ //if ship was discorded at this position for first time

                    hits_left = hits_left - 1; //change hit's that left to do before the game will be finished
                    u.print("\n*************Congrats, it is hit*************\n");
                    miss = false;
                    b.change_my_board(attempt, miss); //send coordinates to mark them at the board

                } else { //if it's miss
                    u.print("\n*************Sorry, it's is a miss*************\n");
                    miss = true;
                    b.change_my_board(attempt, miss);//send coordinates to mark them at the board
                }
                p.change_score(miss); //change the score of this particular player
                u.print("*******"+p_list.get(i).getScore());
            }

        } while(hits_left != 0);


    }



    //method to get valid cooridinates greater that 0 and less than x/y
     String valid_coordinates(){
        int user_x, user_y;
        String attempt;
        int print_x = x - 1;
        int print_y = y - 1;
        boolean ready;

        u.print("Insert coordinates (x,y)");

         do { //loop to get coordinates from user and validate them properly

             attempt = u.validation("[0-9]+[,][0-9]+", "\nPlease use just numbers in format like this 0,0 ");

             String[] parts = attempt.split(","); //splitting input to coordinates x and y
             user_x = Integer.parseInt(parts[0]);
             user_y = Integer.parseInt(parts[1]);

             if(user_x <= print_x && user_y <= print_x){ //if both values are existing in on the board
                 if(is_it_ok(user_x,user_y)){ //and this coordinates haven't been used that return coordinates back
                     ready = true;
                 } else { //all other else just made to make it cleare for user what exactly wrong with his coordinates
                     u.print("This coordinate was used before. Please chose different coordinates");
                     ready = false; }
             } else {
                 ready = false;
                 u.print("Value is too big! Please insert just numbers from 1 to " + print_x + " for x and from 1 to "
                         + print_y + " for y\nIn format like this(0,0)");
             }

         } while (ready == false);

        return attempt;
    }

    //method that checking if users input equals an existing value in ships coordinate array
    public boolean is_it_hit(String input){
        String[] ship_cord = b.getMy_ship(); //getting ship coordinates
        return Arrays.stream(ship_cord).parallel().anyMatch(input::equals); //checking
    }

    //method that checks if this spot has been hit before
    public boolean is_it_ok(int u_x, int u_y){
        String val_at_position = b.getMy_board()[u_x][u_y];
        if(val_at_position.equals("-")){ //if symbol equals - this spot is empty
            return true;
        } else { //other players checked this spot
            return false;
        }


    }

    //method to start new game with same players or new players
    void play_again(){

        u.print("Do you want to play again? \nPress 1 to start again. Press 2 to exit program");
        String play_again = u.validation("[1-2]", "Please use just numbers 1 or 2"); //validation

        if(play_again.equals("1")){
            u.print("Do you want to change players? \nPress 1 to play with same people. Press 2 to start with new players.");
            String same_players = u.validation("[1-2]", "Please use just numbers 1 or 2");
            //if player don't want to re-enter all information program will reset board
            if(same_players.equals(1)){
                new_board();
            } else {
             start();   //or start from the beginning
            }

        } else {
            System.exit(0); //or exit the game
        }

    }




}
