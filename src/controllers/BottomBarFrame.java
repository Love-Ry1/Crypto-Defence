package controllers;

import controllers.BottomBarButtons;
import models.Shop;

import javax.swing.*;
import java.awt.*;


public class BottomBarFrame {
    private int x, y, width, height;
    private BottomBarButtons tower1, tower2, tower3, tower4;
    private BottomBarButtons nextLevel;
    private GameScreen gameScreen;
    private boolean buttonPress1 = false;
    private Shop shop;


    public BottomBarFrame(int x, int y, int width, int height, GameScreen gameScreen) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameScreen = gameScreen;
        Buttons();
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
        tower1.draw(g);
        tower2.draw(g);
        tower3.draw(g);
        nextLevel.draw(g);
    }


    public void Buttons() {
        Image image = new ImageIcon(getClass().getResource("/basictower.png"), "models.BasicTower").getImage();
        tower1 = new BottomBarButtons("tower1", 110, 850, 100, 70, image);
        tower2 = new BottomBarButtons("tower2", 270, 850, 100, 70, image);
        tower3 = new BottomBarButtons("tower3", 430, 850, 100, 70, image);
        image = new ImageIcon(getClass().getResource("/nextlevel.png"), "controller.nextlevel").getImage();
        nextLevel = new BottomBarButtons("Next Level", 590, 850, 100, 70, image);
    }

    public void setShop(Shop shop){
        this.shop = shop;
    }

    public void mouseClicked(int x, int y) {
    }

    public boolean getButton1Pressed(){
        return buttonPress1;
    }

    public int getY(){
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



    }

    public void mousePressed(int x, int y) {
        tower1.setMousePressed(false);
        if (tower1.getInitialBound().contains(x, y)) {  //checks if tower1 bounds are pressed (so if the button is pressed)
            shop.setButton1(true);
            tower1.setMousePressed(true);
        }

        tower2.setMousePressed(false);
        if (tower2.getInitialBound().contains(x, y)) {
            shop.setButton1(true);
            tower2.setMousePressed(true);
        }

        tower3.setMousePressed(false);
        if (tower3.getInitialBound().contains(x, y)) {
            shop.setButton1(true);
            tower3.setMousePressed(true);
        }

        nextLevel.setMousePressed(false);
        if (nextLevel.getInitialBound().contains(x, y)) {
            gameScreen.getGameModel().getMobWave().nextLevel();

            System.out.println("You pressed next level!");

        }


    }

    public void mouseReleased(int x, int y) {
    }





}
