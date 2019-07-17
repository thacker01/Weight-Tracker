package com.thacker.main;

import com.thacker.logic.AppStartLogic;
import com.thacker.logic.DataFileLogic;
import com.thacker.logic.User;
import com.thacker.logic.UserData;

public class Main {
    public static void main(String[] args) throws Exception{

        DataFileLogic dfl = new DataFileLogic();
        UserData u = null;

        //Create UserData object if no users are present
        if(dfl.emptyFile){
            u = new UserData();
        }

        //Add User
        u.addUser("James", 220);
        u.addUser("Liza", 250);
        u.addUser("Loser(Cody)", 150);

        //Print users

        int count = 1;
        for(User x: u.users){
            System.out.println(count + ") " + x.getName());
            count++;
        }






//        //Begin application
//        AppStartLogic app = AppStartLogic.createInstance();
//        boolean exitStatus = app.begin();
//
//        if(exitStatus){
//            System.out.println("SUCCESS");
//        }else{
//            System.out.println("FAILURE");
//        }
    }
}
