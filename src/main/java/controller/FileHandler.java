package controller;

import model.DataHandler;

import java.io.*;

public class FileHandler {

    private static DataHandler dataHandler;

    public FileHandler(DataHandler data){
        this.dataHandler = data;
    }

    public static void saveToFile(){
        try {
            FileOutputStream fileOut = new FileOutputStream("/src/main/resources/usersData.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dataHandler);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful... Checkout your specified output file..\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataHandler readFromFile(){
        DataHandler data = new DataHandler();
        try {
            FileInputStream fileIn = new FileInputStream("/src/main/resources/usersData.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            System.out.println("Deserialized Data");
            in.close();
            fileIn.close();
            data = (DataHandler) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }return data;

    }
}
