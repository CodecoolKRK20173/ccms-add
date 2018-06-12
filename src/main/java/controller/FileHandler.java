package controller;

import model.DataHandler;

import java.io.*;

public class FileHandler {

    private DataHandler dataHandler;

    public FileHandler(DataHandler data){
        this.dataHandler = data;
    }

    public void saveToFile(){
        try {
            FileOutputStream fileOut = new FileOutputStream("/src/main/resources/usersData.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.dataHandler);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful... Checkout your specified output file..\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        try {
            FileInputStream fileIn = new FileInputStream("/src/main/resources/usersData.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            System.out.println("Deserialized Data: \n" + in.readObject().toString());
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
