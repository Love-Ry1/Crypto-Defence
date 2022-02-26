package models;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadGame {
    public GameModel loadState(){
        GameModel gameModel = null;
        try {
            FileInputStream fileIn = new FileInputStream("modelState.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gameModel = (GameModel) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return gameModel;
    }
}
