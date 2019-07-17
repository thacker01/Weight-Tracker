package com.thacker.logic;

import com.thacker.main.Resources;

import java.io.*;

public class DataFileLogic {

    /**
     * Class handles all operations on the data file
     */

    private RandomAccessFile rfile = null;
    private UserData userData = null;
    public boolean emptyFile; ///////////////////////////////MAKE PRIVATE LATER

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
        }//Reverify file

        //Check if data file is empty
        emptyFile = isFileEmpty();

        System.out.println(emptyFile);




    }

    public void readFile(){

        try {
            byte[] b = new byte[(int) rfile.length()];

            rfile.read(b);

            ByteArrayInputStream bis = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream(bis);

            userData = (UserData) ois.readObject();
        }catch(IOException | ClassNotFoundException | ClassCastException e){
            System.out.println("ERROR");
        }
        System.out.println("FILE READ");
    }

    public void writeFile(UserData uObj){
        try {
            deleteFile();   //The plan is to utilize RandomAccessFile's random ability
            createFile();
            if(!verify()){
                throw new IOException("File is corrupt");
            }
            rfile.writeBoolean(emptyFile);


            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(uObj);

            byte[] b = bos.toByteArray();

            rfile.write(b);

        }catch(IOException e){}
    }

    private boolean isFileEmpty(){
        try{
            return rfile.readBoolean();
        }catch(IOException e){
            return true;
        }
    }

    private boolean checkFileStatus(){
        File file = new File(Resources.filename);

        //Check if file exists
        return file.exists();
    }

    public void safelyQuit(){
        closeFile();
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
            rfile.writeBoolean(true);
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
