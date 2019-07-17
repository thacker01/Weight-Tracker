package com.thacker.main;

import com.thacker.logic.AppStartLogic;
import com.thacker.logic.DataFileLogic;

public class Main {
    public static void main(String[] args) {

        //Begin application
        AppStartLogic app = AppStartLogic.createInstance();
        boolean exitStatus = app.begin();

        if(exitStatus){
            System.out.println("SUCCESS");
        }else{
            System.out.println("FAILURE");
        }
    }
}
