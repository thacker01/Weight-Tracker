package com.thacker.logic;

import com.thacker.main.Resources;

import java.io.*;

public class DataFileLogic {

    /**
     * Class handles all operations on the data file
     */

    private RandomAccessFile rfile;

    public DataFileLogic(){



        if(checkFileStatus()){
            linkFile();
        }else {
            createFile();
        }

        //Verify File
        if(!verify()){
            System.out.println("file corrupt");
            deleteFile();
            createFile();
        }






    }

    private boolean checkFileStatus(){
        File file = new File(Resources.filename);

        //Check if file exists
        return file.exists();
    }

    private void closeFile(){
        try {
            rfile.close();
        }catch (IOException e){}
    }

    private void linkFile(){
        try {
            rfile = new RandomAccessFile(Resources.filename, "rw");
        }catch(FileNotFoundException e){
            System.out.println("E-101: File Not Found");
        }
    }

    private void createFile(){
        try {
            linkFile();
            rfile.writeUTF(Resources.verification);
            rfile.seek(0);
        } catch (IOException e) {}
    }

    private void deleteFile(){
        new File(Resources.filename).delete();
    }

    private boolean verify(){

        try{
            if(rfile.readUTF().equals(Resources.verification)){
                return true;
            }else{
                return false;
            }
        }catch(IOException e){
            return false;
        }

    }
}
