package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This class notifies whenever you change the state of your mouse
 *  @author Fadi Abunaj
 *  @version 2022-03-06
 */
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
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gameFrame.getGameScreen().mousePressed(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
