package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//import controllers.GameFrame;


public class MyMouseListener implements MouseListener, MouseMotionListener {

    private final GameFrame gameFrame;

    public MyMouseListener(GameFrame game) {
        this.gameFrame = game;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gameFrame.getGameScreen().mouseMoved(e.getX(), e.getY());

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //if (e.getButton()== MouseEvent.BUTTON1){   ---- Checks the coordinates if you left click on the frame
        //    System.out.println("Left button");
        //    System.out.println("X: "+ e.getX() + " " +"Y: "+ e.getY());
        //}
        //gameFrame.getGameScreen().mouseClicked(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gameFrame.getGameScreen().mousePressed(e.getX(), e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //gameFrame.getGameScreen().mouseReleased(e.getX(), e.getY());

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
