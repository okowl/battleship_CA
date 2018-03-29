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

    //just a welcome method that prints some rules and initiates collecting of information about utility in utility class
    void welcome(){
        System.out.println("***************************************************"+"\n"+"\n"+"Welcome to the BattleShip Game of the year edition" +
                "\n You can play it alone or with friends"+"\n"+"\n"+"***************************************************");
        game play = new game();
        play.menu();
    }

    public static void main(String[] args) {
        new Main();
    }
}
