package com.company;

/*
* Battle ship CA
* Student name: Olga Kiseleva
* Student number: 2017136 IT2017 Group A
*/

public class Main {

    //int[] ages;

    public Main(){
        welcome();

        /*int numberOfPlayers = 1; // you can use br.readLine for storing value here

        if(numberOfPlayers == 1){
            utility player1 = new utility("Olga", "23", "blah@gmail.com");
        }else if (numberOfPlayers == 2){
            utility player1 = new utility("Olga", "23", "blah@gmail.com");
            utility player2 = new utility("Felipe", "26", "bleh@gmail.com");
        }

        this.age = new int[numberOfPlayers];


        //WHERE WIL THE INFORMATION SUCH AS AGE, NAME AND EMAIL WILL BE STORED? AT PLAYERS CLASS



    */}

    //just a welcome method that prints some rules and initiates collecting of information about utility in utility class
    void welcome(){
        System.out.println("***************************************************"+"\n"+"\n"+"Welcome to the BattleShip Game of the year edition" +
                "\n You can play it alone or with friends"+"\n"+"\n"+"***************************************************");
        utility play = new utility();
        play.menu();
    }

    public static void main(String[] args) {
        new Main();
    }
}
