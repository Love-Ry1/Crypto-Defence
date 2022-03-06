package models;

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
        BasicMap basicMap = new BasicMap();
        MobWave mobWave = new MobWave(basicMap);

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




}
