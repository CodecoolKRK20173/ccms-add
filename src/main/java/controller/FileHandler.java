package controller;

import model.DataHandler;
import view.View;
import java.io.*;

public class FileHandler {

    public static DataHandler readFromFile(String filename, View view) {

        DataHandler dataHandler = null;
        FileInputStream fileIn = null;
        ObjectInputStream input = null;

        try {
            fileIn = new FileInputStream(filename);
            input = new ObjectInputStream(fileIn);
            dataHandler = (DataHandler) input.readObject();
            view.printMessage("Data deserialized."); 
            
            input.close();
            fileIn.close();             
        } catch (IOException | ClassNotFoundException e) {
            view.printMessage("No file, start from scratch!"); 
        } 
        return dataHandler;
    }

    public static void saveToFile(DataHandler dataHandler, String filename, View view) {
        FileOutputStream fileOut = null;
        ObjectOutputStream output = null;

        try {
            fileOut = new FileOutputStream(filename);
            output = new ObjectOutputStream(fileOut);
            output.writeObject(dataHandler);
            view.printMessage("Serialization Successful.\nCheckout your specified output file.");
        
            output.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
