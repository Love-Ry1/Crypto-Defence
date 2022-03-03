package controllers;

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
