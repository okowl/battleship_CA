package com.company;

public class Player {

    private String name;
    private String mail;
    private int age;
    private int score;

    //creating an instance to make my Utility methods accessible here
    Utility u = new Utility();

    //method to get all data from user and create a Player
    void get_info(){
        //starting with the name of the Player
        u.print("Enter your first name please");
        String first_n = u.validation("[a-zA-Z]+", "Please use just an alphabet or translate it");
        /*u.print("Enter your last name");
        String last_n = u.validation("[a-zA-Z]+", "Please use just an alphabet or translate it");*/
        name = first_n + " " /*+ last_n*/;

        //now email
        //u.print("Insert your email address please");
        //regex pattern that checks right pattern for email address with the limits for parts before and after @ and after .
        /*mail = u.validation("[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}",
                "Invalid email address, please enter a valid one ");
*/
        //now age
        /*u.print("How old are you?");
        String p_age = u.validation("[1-9]+", "Please use just a numbers");
        age = Integer.parseInt(p_age);*/
    }

    //method that will change players score
    void change_score(Boolean was_miss){
        if(was_miss){
            this.score = this.score + 2; //if miss + 2
        } else {
            this.score = this.score - 1; // if hit + 1
        }
    }

    //here are getters
    public String getName() {
       return name;
   }
    /*public String getMail() {
        return mail;
    }
    public int getAge() {
        return age;
    }*/
    public int getScore() {
        return score;
    }


}
