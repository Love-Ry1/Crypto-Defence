package models;

import controllers.GameFrame;

/**
 * This class initializes the game
 *  @author Mustafa Bawi
 *  @version 2022-03-06
 */
public class Main {

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.getGameScreen().initInputs();
        GameModel gameModel = new GameModel(gameFrame.getGameScreen());
        gameModel.run();
    }
}
