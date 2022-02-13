import java.awt.*;

public class DrawTowers {
    GameModel gameModel;

    public DrawTowers(GameModel gameModel){
        this.gameModel = gameModel;
    }

    public void draw(Graphics2D g){
        Tower[][] towers = gameModel.getTowerMap();

        for(int i = 0; i < gameModel.getHeight(); i++){
            for(int j = 0; j < gameModel.getWidth(); j++){
                Tower currentTower = towers[i][j];
                if(currentTower != null){
                    g.drawImage(currentTower.getTowerImage(), currentTower.getPosX() +
                                    ((Block.getWidth() - currentTower.getTowerImage().getWidth(null)) / 2),
                            currentTower.getPosY() + ((Block.getHeight() - currentTower.getTowerImage().getHeight(null)) / 2),null);
                }
            }
        }
    }
}
