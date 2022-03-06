package models;

import controllers.GameFrame;
import controllers.GameScreen;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {
    @Test
    public void towersShootsBulletsAtEnemies() {
        Tower tower = new BasicTower(0, 0);
        BasicMap basicMap = new BasicMap();
        MobWave mobWave = new MobWave(basicMap);
        Enemy enemy = new Enemy1(80, 0, mobWave);

        assertEquals(0, tower.getBullets().size());
        tower.shoot(enemy);
        assertTrue(tower.getBullets().size() > 0);
    }

    @Test
    public void playerTakeDamage(){
        Player player = new Player();
        int OldHealth = player.getHealth();

        assertEquals(100, player.getHealth());
        player.takeDamage(10);
        assertEquals(player.getHealth(), OldHealth - 10);
    }

    @Test
    public void addTowerOnMapWithShop(){
        Shop shop = new Shop();
        assertFalse(shop.addTower());
        shop.setButton1(true);
        shop.setCoordinates(100,100);
        assertTrue(shop.addTower());
    }

    @Test
    public void getCoordinatesToBlockInGameModel(){
        GameModel gameModel = new GameModel(new GameScreen(new GameFrame()));

        gameModel.posToBlock(50, 50);
        assertEquals(0, gameModel.getCurrentBlockX());
        assertEquals(0, gameModel.getCurrentBlockY());

        gameModel.posToBlock(200, 100);
        assertEquals(2, gameModel.getCurrentBlockX());
        assertEquals(1, gameModel.getCurrentBlockY());
    }

    @Test
    public void bulletsMovingInRightDirection(){
        Enemy enemy = new Enemy1(100, 100, new MobWave(new BasicMap()));
        Bullets bullet = new BasicBullet(1, 1, enemy);

        bullet.update();
        assertTrue(bullet.getPosX() > 1);
        assertTrue(bullet.getPosY() > 1);
    }

}
