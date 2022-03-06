package controllers;

/**
 * This is the interface that has methods for the mouse
 *  @author Fadi Abunaj
 *  @version 2022-03-06
 */
public interface MouseMethods {

    /**
     * Method for when the mouse is moved in the bounds of x and y
     * @param x for x-coordinates
     * @param y for y-coordinates
     */
    void mouseMoved(int x, int y);

    /**
     * Method for when the mouse is Pressed in the bounds of x and y
     * @param x for x-coordinates
     * @param y for y-coordinates
     */
    void mousePressed(int x, int y);


}
