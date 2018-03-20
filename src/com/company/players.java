package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class players {


    String number_players;
    String age_p1, age_p2, age_p3, age_p4;

    void menu(){
        System.out.println("\nHow many players do we have today?\nMin = 1, max = 4");
        number_players = validation("[1-4]+", "!!!!!! Please enter just a numbers from 1 to 4 !!!!!!");
    }


    public String read_from_keyboard(){
        String text = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            text = br.readLine();
        }catch(Exception e){}
        return text;
    }

    public String validation (String regex, String Error){
        boolean valid;
        String txt;

        do{
            txt = read_from_keyboard();
            if(!txt.matches(regex)){
                valid = false;
                System.out.println(Error);

            }else{
                valid = true;
            }
        }while(!valid);

        return txt;
    }


}
