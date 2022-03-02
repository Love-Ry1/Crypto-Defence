package models;

import controllers.GameFrame;

public class Main {

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.getGameScreen().initInputs();
        GameModel gameModel = new GameModel(gameFrame.getGameScreen());
        gameModel.run();
    }
}
