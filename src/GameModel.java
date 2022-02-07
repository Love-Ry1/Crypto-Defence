import java.awt.*;

public class GameModel {
    private final int width;
    private final int height;
    private Tower[][] towerMap;
    private int currentBlockX;
    private int currentBlockY;

    public GameModel(){
        this.width = BasicMap.getWidth();
        this.height = BasicMap.getHeight();
        this.towerMap = new Tower[width][height];
    }

    // The idea is that we get the position of the mouse and the functions uses it to find the current "Block"
    // There is probably a better way to this lol
    public void posToBlock(int posX, int posY){
        currentBlockX = posX / Block.getHeight();
        currentBlockY = posY / Block.getWidth();
    }

    public void addTower(int posX, int posY, Tower.TowerName towerName) {
        posToBlock(posX, posY);
        BasicTower newTower = null;
        if (towerName == Tower.TowerName.BASIC) {
            newTower = new BasicTower(currentBlockX * Block.getWidth(), currentBlockY * Block.getHeight());
        }
        towerMap[currentBlockX][currentBlockY] = newTower;
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
