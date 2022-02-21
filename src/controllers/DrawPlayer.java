package controllers;
import models.Player;
import java.awt.*;

public class DrawPlayer {
    Player player;

    public DrawPlayer(Player player){
        this.player = player;
    }

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

