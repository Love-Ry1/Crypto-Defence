package models;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
    private GameModel gameModel;

    public SaveGame(GameModel gameModel){
        this.gameModel = gameModel;
    }

    public void saveGame(){
        try {
            FileOutputStream fileOut = new FileOutputStream("modelState.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameModel);
            out.close();
            fileOut.close();
            System.out.println("saved!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
