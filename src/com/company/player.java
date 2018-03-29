package com.company;

public class player {

    private String name;
    private String mail;
    private Integer age;


    //creating an instance to make my utility methods accessible here
    utility u = new utility();


    //method to get all data from user and create a player
    void player(){
        //starting with the name of the player
        u.print("Enter your first name please");
        String first_n = u.validation("[a-zA-Z]+", "Please use just an alphabet or translate it");
        u.print("Enter your last name");
        String last_n = u.validation("[a-zA-Z]+", "Please use just an alphabet or translate it");
        //name is now ready
        name = first_n + " " + last_n;

        //now email
        u.print("Insert your email address please");
        //regex pattern that checks right pattern for email address with the limits for both parts
        mail = u.validation("[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}",
                "Invalid email address, please enter a valid one ");

        //now age
        u.print("How old are you?");
        String p_age = u.validation("[1-9]+", "Please use just a numbers");
        age = Integer.parseInt(p_age);
    }

   public String getName() {
       return name;
   }
    public String getMail() {
        return mail;
    }
    public int getAge() {
        return age;
    }


}
