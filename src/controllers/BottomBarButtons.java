package controllers;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BottomBarButtons implements MouseMethods {

    public int x, y, width, height, id;
    private final String text;
    private Rectangle bounds; // a rectangle that checks if our x- and y- are inside the buttons bounds.
    private boolean mouseOver, mousePressed;

    // For normal controllers.Buttons
    public BottomBarButtons(String text, int x, int y, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initialBounds();
    }

    private void initialBounds() {
        this.bounds = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D gr) {

        // Draws the body for button
        drawBody(gr);

        // Draws the border for the button
        drawBorder(gr);


        // Draws the text for button
        drawText(gr);

    }

    public Rectangle getInitialBound() {
        return bounds;
    }

    private void drawBody(Graphics2D g) {
        //g.setColor(Color.blue);
        //g.fillRect(x, y, width, height);


        if (mouseOver) {
            g.setColor(Color.gray);  // does not work
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);
        }

    }

    private void drawBorder(Graphics2D g) {
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);

    }

    private void drawText(Graphics2D g) {
    }

    @Override
    public void mouseClicked(int x, int y) {

    }

    @Override
    public void mouseMoved(int x, int y) {

    }

    @Override
    public void mousePressed(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {

    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

}
