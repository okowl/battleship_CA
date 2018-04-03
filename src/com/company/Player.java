package com.company;

public class Player {

    private String name;
    private String mail;
    private int age;
    private int hits = 0;
    private int miss = 0;

    //creating an instance to make my Utility methods accessible here
    Utility u = new Utility();

    //method to get all data from user and create a Player
    void get_info(){
        //starting with the name of the Player
        u.print("Enter your first name please");
        String first_n = u.validation("[a-zA-Z]+", "Please use just an alphabet or translate it");
        u.print("Enter your last name");
        String last_n = u.validation("[a-zA-Z]+", "Please use just an alphabet or translate it");
        name = first_n + " " + last_n;

        //now email
        u.print("Insert your email address please");
        //regex pattern that checks right pattern for email address with the limits for parts before and after @ and after .
        mail = u.validation("[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}+[.]+[a-zA-Z.]{2,6}",
                "Invalid email address, please enter a valid one ");

        //now age
        u.print("How old are you?");
        String p_age = u.validation("[1-9]+", "Please use just a numbers");
        age = Integer.parseInt(p_age);
    }

    //if player hit ship hits + 1
    public void change_hits(){
        this.hits += 1;
    }
    //if player doesn't hit ship miss + 1
    public void change_miss(){
        this.miss += 1;
    }

    //method that resets all scores for all players if they want to play again
    public void reset_score(){
        this.hits = 0;
        this.miss = 0;
    }

    //here are getters
    public String getName() {
       return name;
   }
    public String getMail() {
        return mail;
    }
    public int getAge() {
        return age;
    }

    public int getHits(){
        return hits;
    }
    public int getMiss(){
        return miss;
    }


}
