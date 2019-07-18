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
    private boolean terminate = false;

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
    public void begin(){

        //Check and or create data file
        dataFile = new DataFileLogic();

        in = new Scanner(System.in);
        int userInput = 0;

        //Create and display the application menu

        System.out.println(Resources.appName + " ver: " + Resources.version + "\n");

        //Display application menu
        Menu.printMenu();

        //Begin main application loop
        while (!terminate){

            //Get user input
            int choice = getChoice();

            if(choice == -1){
                continue;
            }

            //Perform chosen operation
            execute(choice);

        }
    }

    /**
     * Executes the option specified by the user
     * @param choice represents the user choice
     */
    private void execute(int choice){
        switch(choice){
            case 0:
                System.out.println("Goodbye and have a nice day!");
                this.terminate = true;
        }
    }

    /**
     * Get and validate user choice
     * @return valid choice
     */
    private int getChoice(){

        int userInput = -1;

        //Prompt user for choice
        System.out.print("\nPlease select an option[1-" + Resources.options.length + "]: ");

        //Get input
        try{
            userInput = in.nextInt();
        }catch(InputMismatchException e){
            if(in.nextLine().equalsIgnoreCase("q")){
                userInput = 0;
            }
        }

        //Verify user input
        if(userInput != 0 && (userInput < 1 || userInput > Resources.options.length)){
            System.out.println("Sorry, your choice was incorrect. Please select a valid option");
            userInput = -1;
        }

        return userInput;
    }

}
