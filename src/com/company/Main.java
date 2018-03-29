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
    }

    //just a welcome method that prints some rules and initiates collecting of information about Utility in Utility class
    void welcome(){
        System.out.println("***************************************************"+"\n"+"\n"+"Welcome to the BattleShip Game of the year edition" +
                "\n You can play it alone or with friends"+"\n"+"\n"+"***************************************************");
        Game play = new Game();
        play.start();
    }

    public static void main(String[] args) {
        new Main();
    }
}
