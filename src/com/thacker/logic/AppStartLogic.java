package com.thacker.logic;

import com.thacker.main.Resources;
import com.thacker.main.Menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppStartLogic {

    /**
     * Contains the logic that runs the entire application
     */

    private static AppStartLogic instance = null;
    private DataFileLogic dataFile = null;
    private Scanner in = null;

    //Private constructor to prevent create a new instance from outside of class
    private AppStartLogic(){};

    //Return the active instance
    public static AppStartLogic createInstance(){
        if(instance == null) {
            instance = new AppStartLogic();
        }

        return instance;
    }

    /**
     * Starts the application
     * @return whether the application completed successfully or not
     */
    public boolean begin(){

        //Check and or create data file
        dataFile = new DataFileLogic();

        in = new Scanner(System.in);
        int userInput = 0;

        //Create and display the application menu

        System.out.println(Resources.appName + " ver: " + Resources.version + "\n");

        //Display application menu
        Menu.printMenu();

        //Begin main application loop
        while (true){

            //Get user input

            /////////////////////////////////////////////////CLEAN THIS UP

            System.out.print("\nPlease select an option[1-" + Resources.options.length + "]: ");

            try{
                userInput = in.nextInt();
            }catch(InputMismatchException e){
                in.nextLine();
            }

            /**Check user input*/

            if(userInput < 1 || userInput > Resources.options.length){
                System.out.println("Sorry, your choice was incorrect. Please select a valid option");
                continue;
            }

            /**Perform chosen operation*/
            break;
        }




        return true;
    }


//
//
//
//
//
//
//
//

}
