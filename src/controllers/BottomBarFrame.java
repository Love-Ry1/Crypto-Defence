package controllers;

import controllers.BottomBarButtons;
import models.Player;
import models.Shop;
import models.Server;

import javax.swing.*;
import java.awt.*;

/**
 * This BottomBarFrame creates the frame for the bottom bar and initializes the buttons from the BottomBarButtons class
 */
public class BottomBarFrame implements MouseMethods{
    private int x, y, width, height;
    private BottomBarButtons tower1, tower2, tower3;
    private BottomBarButtons nextLevel, save, load, connect;
    private GameScreen gameScreen;
    private Server server;
    private boolean buttonTower1, buttonTower2, buttonTower3, buttonNextLevel, buttonSave, buttonLoad;

    /**
     * This constructor initializes a frame with the following bounds
     * @param x the x-coordinate of the frame
     * @param y the y-coordinate of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     * @param gameScreen the current gameScreen
     */
    public BottomBarFrame(int x, int y, int width, int height, GameScreen gameScreen) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameScreen = gameScreen;
        Buttons();
    }

    /**
     * This method will draw the BottomBarFrame and buttons
     *
     * @param g
     */
    public void draw(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
        tower1.draw(g);
        tower2.draw(g);
        tower3.draw(g);
        nextLevel.draw(g);
        save.draw(g);
        load.draw(g);
        connect.draw(g);
    }

    /**
     * This method will assign our buttons with x, y, width, height values and an image
     */
    public void Buttons() {
        Image image = new ImageIcon(getClass().getResource("/basictower.png"), "models.BasicTower").getImage();
        tower1 = new BottomBarButtons(110, 850, 100, 70, image);
        tower2 = new BottomBarButtons(270, 850, 100, 70, image);
        tower3 = new BottomBarButtons(430, 850, 100, 70, image);

        image = new ImageIcon(getClass().getResource("/nextlevel.png"), "controller.nextlevel").getImage();
        nextLevel = new BottomBarButtons(590, 850, 100, 70, image);

        image = new ImageIcon(getClass().getResource("/save.png"), "save").getImage();
        save = new BottomBarButtons(20, 850, 50, 20, image);

        image = new ImageIcon(getClass().getResource("/load.png"), "save").getImage();
        load = new BottomBarButtons(20, 880, 50, 20, image);

        // image = new ImageIcon(getClass().getResource("/connect.png"), "connection").getImage();
        connect = new BottomBarButtons(20, 910, 50, 20, image);
    }



    /**
     * This method returns the y-value
     *
     * @return the y-coordinate value for our BottomBarFrame
     */
    public int getY() {
        return y;
    }

    public void mouseMoved(int x, int y) {  // checks if the mouse is hovering over the bounds of tower1
        tower1.setMouseOver(false);
        if (tower1.getInitialBound().contains(x, y)) {
            tower1.setMouseOver(true);
        }

        tower2.setMouseOver(false);
        if (tower2.getInitialBound().contains(x, y)) {
            tower2.setMouseOver(true);
        }

        tower3.setMouseOver(false);
        if (tower3.getInitialBound().contains(x, y)) {
            tower3.setMouseOver(true);
        }

        nextLevel.setMouseOver(false);
        if (nextLevel.getInitialBound().contains(x, y)) {
            nextLevel.setMouseOver(true);
        }

        save.setMouseOver(false);
        if (save.getInitialBound().contains(x, y)) {
            save.setMouseOver(true);
        }

        load.setMouseOver(false);
        if (load.getInitialBound().contains(x, y)) {
            load.setMouseOver(true);
        }
        connect.setMouseOver(false);
        if (connect.getInitialBound().contains(x, y)) {
            connect.setMouseOver(true);
        }
    }

    public void mousePressed(int x, int y) {
        tower1.setMousePressed(false);
        if (tower1.getInitialBound().contains(x, y)) {  //checks if tower1 bounds are pressed (so if the button is pressed)
            tower1.setMousePressed(true);
            buttonTower1 = true;
        }

        tower2.setMousePressed(false);
        if (tower2.getInitialBound().contains(x, y)) {
            tower2.setMousePressed(true);
            buttonTower1 = true;
        }

        tower3.setMousePressed(false);
        if (tower3.getInitialBound().contains(x, y)) {
            tower3.setMousePressed(true);
            buttonTower1 = true;
        }

        nextLevel.setMousePressed(false);
        if (nextLevel.getInitialBound().contains(x, y)) {
            buttonNextLevel = true;
        }

        save.setMousePressed(false);
        if (save.getInitialBound().contains(x, y)) {
            buttonSave = true;
        }

        load.setMousePressed(false);
        if (load.getInitialBound().contains(x, y)) {
            buttonLoad = true;
        }

        connect.setMousePressed(false);
        if (connect.getInitialBound().contains(x, y)) {
            System.out.println("connect!!!!!!!!!");
        }
    }

    /**
     * This isButtonTower1 method returns the boolean type of buttonTower1
     *
     * @return the boolean type of buttonTower1
     */
    public boolean isButtonTower1() {
        return buttonTower1;
    }

    public boolean isButtonTower2() {
        return buttonTower2;
    }

    public boolean isButtonTower3() {
        return buttonTower3;
    }

    /**
     * This isButtonNextLevel method returns the boolean type of buttonNextLevel
     *
     * @return the boolean type of buttonNextLevel
     */
    public boolean isButtonNextLevel() {
        return buttonNextLevel;
    }

    /**
     * This isButtonSave method returns the boolean type of buttonSave
     *
     * @return the boolean type of buttonSave
     */
    public boolean isButtonSave() {
        return buttonSave;
    }

    /**
     * This isButtonLoad method returns the boolean type of buttonLoad
     *
     * @return the boolean type of buttonLoad
     */
    public boolean isButtonLoad() {
        return buttonLoad;
    }

    /**
     * This resetButtons method sets the boolean type for buttonLoad, buttonSave and buttonNextLevel to false
     */
    public void resetButtons() {
        buttonLoad = false;
        buttonSave = false;
        buttonNextLevel = false;
    }

}
