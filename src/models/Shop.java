package models;

/**
 * This class is for creating the panel that displays the Towers and the things you can buy in the game
 */
public class Shop {
    private boolean button1 = false;
    private int posX = -1, posY = -1;

    /**
     * This method is for setting the button on the map
     * @param button1 the boolean used to reset the towershop whenever we add a tower to the map
     */
    public void setButton1(boolean button1){
        this.button1 = button1;
    }

    /**
     * This method is for setting the coordinates
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public void setCoordinates(int x, int y){
        if (button1) {
            this.posX = x;
            this.posY = y;
        }
    }

    /**
     * This method returns the x-coordinate
     * @return the x-coordinate
     */
    public int getPosX(){
        return posX;
    }

    /**
     * This method returns the y-coordinate
     * @return the y-coordinate
     */
    public int getPosY(){
        return posY;
    }

    /**
     * This method reset the position x,y and button
     */
    public void reset(){
        posX = -1;
        posY = -1;
        button1 = false;
    }

    /**
     * This method returns the boolean type of button1
     * @return the boolean type for button1
     */
    public boolean getButton1() {
        return button1;
    }

    /**
     * This method is true if a shop button is pressed and posX and posY is in the game window
     * @return true if a shop button is pressed and posX and posY is in the game window
     */
    public boolean addTower(){
        return (button1 && posX >= 0 && posY >= 0);
    }
}
