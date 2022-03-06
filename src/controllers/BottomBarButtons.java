package controllers;

import java.awt.*;

/**
 * This class creates the buttons for the bottom frame
 * @author Fadi Abunaj
 * @version 2022-03-06
 */
public class BottomBarButtons {
    public int x, y, width, height;
    private Rectangle bounds;       // a rectangle that checks if our x- and y- are inside the buttons bounds.
    private boolean mouseOver, mousePressed;
    private Image image;

    /**
     * @param x      the x-coordinates for the button
     * @param y      the y-coordinate for the button
     * @param width  the width for the button
     * @param height the height for the button
     * @param image  the image for the button
     */
    public BottomBarButtons(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        initialBounds();
    }

    /**
     * This method creates a rectangle that will act as our button
     */
    private void initialBounds() {
        this.bounds = new Rectangle(x, y, width, height);
    }

    /**
     * This method draws our buttons Body and Border
     *
     * @param gr
     */
    public void draw(Graphics2D gr) {
        drawBody(gr);
        drawBorder(gr);
    }

    /**
     * This method returns the bounds for the buttons
     *
     * @return The bounds (so x,y,width,height)
     */
    public Rectangle getInitialBound() {
        return bounds;
    }

    /**
     * This method draws the body for our buttons
     *
     * @param g
     */
    private void drawBody(Graphics2D g) {
        if (mouseOver) {
            g.setColor(Color.gray);
            g.fillRect(x, y, width, height);
            g.drawImage(image, x + width / 2 - (image.getWidth(null) / 2), y + height / 2 - image.getHeight(null) / 2 - 2, null);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);
            g.drawImage(image, x + width / 2 - (image.getWidth(null) / 2), y + height / 2 - image.getHeight(null) / 2, null);
        }
    }

    /**
     * This method draws the border for our buttons
     *
     * @param g
     */
    private void drawBorder(Graphics2D g) {
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        if (mousePressed) {
            g.drawRect(x + 1, y + 1, width - 2, height - 2);
            g.drawRect(x + 2, y + 2, width - 4, height - 4);
            g.drawRect(x + 3, y + 3, width - 6, height - 6);
        }
    }

    /**
     * This method sets the value for mouseOver
     *
     * @param mouseOver the boolean value for mouseOver
     */
    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    /**
     * This method  sets the value for mouseOver
     *
     * @param mousePressed the boolean value for mousePressed
     */
    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

}
