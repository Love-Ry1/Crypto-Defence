package models;


import controllers.GameScreen;

public class Shop {
    private boolean button1 = false;
    private int posX = -1, posY = -1;
    private GameModel gameModel;

    public Shop(GameModel gameModel){
        this.gameModel = gameModel;
    }

    /**
     * This method is for setting the button on the map
     * @param button1
     */
    public void setButton1(boolean button1){
        this.button1 = button1;
        System.out.println("button 1 is true");
    }

    /**
     * This method is for setting the coordinates
     * @param x
     * @param y
     */
    public void setCoordinates(int x, int y){
        if (button1) {
            this.posX = x;
            this.posY = y;
        }
    }

    /**
     * This method returns position x
     * @return
     */
    public int getPosX(){
        return posX;
    }

    /**
     * This methods returns position y
     * @return
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
     * This method add a new Tower on the map
     * @return
     */
    public boolean addTower(){
        return (button1 && posX >= 0 && posY >= 0);
    }
}