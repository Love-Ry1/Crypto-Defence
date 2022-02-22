package models;


import controllers.GameScreen;

public class Shop {
    private boolean button1 = false;
    private int posX = -1, posY = -1;
    private GameModel gameModel;

    public Shop(GameModel gameModel){
        this.gameModel = gameModel;
    }

    public void setButton1(boolean button1){
        this.button1 = button1;
        System.out.println("button 1 is true");
    }

    public void setCoordinates(int x, int y){
        if (button1) {
            this.posX = x;
            this.posY = y;
        }
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public void reset(){
        posX = -1;
        posY = -1;
        button1 = false;
    }

    public boolean addTower(){
        return (button1 && posX >= 0 && posY >= 0);
    }
}
