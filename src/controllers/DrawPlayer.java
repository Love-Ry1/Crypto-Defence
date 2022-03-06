package controllers;
import models.Player;
import java.awt.*;

/**
 * This class will draw our players health and gold and display it on the map
 */
public class DrawPlayer {
    Player player;

    /**
     * This is the constructor for initiating the player
     * @param player
     */
    public DrawPlayer(Player player){
        this.player = player;
    }

    /**
     * This method is for drawing players information such as health and gold
     * @param g
     */
    public void draw(Graphics2D g) {
        if (player != null) {
            Color oldColor = g.getColor();
            g.setColor(Color.white);
            String string = "Health: " + player.getHealth();
            g.drawString("Health: " + player.getHealth(), 10,25);
            g.drawString("Gold: " + player.getGold(), 10,35);
            g.setColor(oldColor);
        }
    }
}

