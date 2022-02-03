import java.awt.*;

public class GameModel {
    private final int width;
    private final int height;
    private Tower[][] towerMap;

    public GameModel(){
        this.width = BasicMap.getWidth();
        this.height = BasicMap.getHeight();
        this.towerMap = new Tower[width][height];
    }

    public void addTower(int x, int y, Tower tower){
        towerMap[x][y] = tower;
    }

    public void drawTowerMap(Graphics2D g){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(towerMap[i][j] != null){
                    towerMap[i][j].drawTower(g);
                }
            }
        }
    }
}
