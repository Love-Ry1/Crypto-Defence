package models;

import controllers.GameFrame;

/**
 * This class initializes the game
 */
public class Main {

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.getGameScreen().initInputs();
        GameModel gameModel = new GameModel(gameFrame.getGameScreen());

        gameFrame.getGameScreen().setGameModel(gameModel);
        gameModel.run();
    }
}
