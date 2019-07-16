package com.thacker.logic;

import com.thacker.main.Resources;

public class Menu {

    /**
     * Class contains the logic for the application menu system
     */

    private Menu(){};

    //Print menu
    public static void printMenu(){
        for(String s: Resources.options){
            System.out.println(s);
        }
    }
}
