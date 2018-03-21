package com.company;

/*
*
*
*
*
*
* */
public class Main {

    //int[] ages;

    public Main(){
        welcome();

        /*int numberOfPlayers = 1; // you can use br.readLine for storing value here

        if(numberOfPlayers == 1){
            players player1 = new players("Olga", "23", "blah@gmail.com");
        }else if (numberOfPlayers == 2){
            players player1 = new players("Olga", "23", "blah@gmail.com");
            players player2 = new players("Felipe", "26", "bleh@gmail.com");
        }

        this.age = new int[numberOfPlayers];


        //WHERE WIL THE INFORMATION SUCH AS AGE, NAME AND EMAIL WILL BE STORED? AT PLAYERS CLASS



    */}

    //just a welcome method that prints some rules and initiates collecting of information about players in players class
    void welcome(){
        System.out.println("***************************************************"+"\n"+"\n"+"Welcome to the BattleShip Game of the year edition" +
                "\n You can play it alone or with friends"+"\n"+"\n"+"***************************************************");
        players play = new players();
        play.menu();
    }

    public static void main(String[] args) {
        new Main();
    }
}
