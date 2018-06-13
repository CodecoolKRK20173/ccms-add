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
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/usersData.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.dataHandler);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful... Checkout your specified output file..\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(Controller controller){
        try {
            FileInputStream fileIn = new FileInputStream("src/main/resources/usersData.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.dataHandler = (DataHandler) in.readObject();
            controller.setDataHandler(this.dataHandler);
            in.close();
            fileIn.close();
            System.out.println("Data deserialized.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DataHandler getDataHandler() {
        return dataHandler;
    }

    public void setDataHandler(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }
}
