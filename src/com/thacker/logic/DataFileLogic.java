package com.thacker.logic;

import com.thacker.main.Resources;

import java.io.*;

public class DataFileLogic {

    /**
     * Class handles all operations on the data file
     */

    private File file = null;
    private DataInputStream fileIn = null;
    private DataOutputStream fileOut = null;

    public DataFileLogic(){

        //Check if file exists
        file = new File(Resources.filename);

        //Test if file exists
        if(!file.exists()){
            createFile(file);
        }

        //Verify File
        if(!verify(file)){
            deleteFile(file);
            createFile(file);
        }
    }

    private void createFile(File file){
        try {
            file.createNewFile();
            fileOut = new DataOutputStream(new FileOutputStream(file));
            fileOut.writeUTF(Resources.verification);
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {

        }
    }

    private void deleteFile(File file){
        file.delete();
    }

    private boolean verify(File file){

        try{
            fileIn = new DataInputStream(new FileInputStream(file));
            String temp = fileIn.readUTF();
            if(temp.equals(Resources.verification)){
                return true;
            }else{
                return false;
            }
        }catch(IOException e){
            return false;
        }

    }
}
