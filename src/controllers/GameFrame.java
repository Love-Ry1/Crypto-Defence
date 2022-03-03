package controllers;

import controllers.GameScreen;

import javax.swing.*;

/**
 * This class creates a JFrame
 */
public class GameFrame extends JFrame {
    private final GameScreen gameScreen;
    //private final BottomBar bottomBar;

    /**
     * This is the constructor for initiating the frame
     */
    public GameFrame() {
        this.gameScreen = new GameScreen(this);

        // Frame settings
        this.setSize(815, 1000);
        this.setTitle("Crypto Defence");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);       // makes the frame appear around the center of the monitor
        this.setResizable(false);

        // Adding the screen
        this.add(gameScreen);
        this.setVisible(true);
    }

    /**
     * This method returns the gamescreen that the JFrame uses
     * @return the gamescreen
     */
    public GameScreen getGameScreen() {
        return this.gameScreen;
    }


}
