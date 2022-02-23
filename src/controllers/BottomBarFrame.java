package controllers;

import controllers.BottomBarButtons;
import models.Shop;

import java.awt.*;


public class BottomBarFrame {
    private int x, y, width, height;
    private BottomBarButtons tower1, tower2, tower3, tower4;
    private Shop shop;


    public BottomBarFrame(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Buttons();
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
        tower1.draw(g);
        tower2.draw(g);
        tower3.draw(g);
        tower4.draw(g);
    }


    public void Buttons() {
        tower1 = new BottomBarButtons("tower1", 110, 850, 100, 70);
        tower2 = new BottomBarButtons("tower2", 270, 850, 100, 70);
        tower3 = new BottomBarButtons("tower3", 430, 850, 100, 70);
        tower4 = new BottomBarButtons("tower4", 590, 850, 100, 70);
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void mouseClicked(int x, int y) {


    }


    public int getY() {
        return y;
    }

    public void mouseMoved(int x, int y) {  // checks if the mouse is hovering over the bounds of the towers
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

        tower4.setMouseOver(false);
        if (tower4.getInitialBound().contains(x, y)) {
            tower4.setMouseOver(true);
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

        tower4.setMousePressed(false);
        if (tower4.getInitialBound().contains(x, y)) {
            shop.setButton1(true);
            tower4.setMousePressed(true);
        }


    }

    public void mouseReleased(int x, int y) {

    }


}
