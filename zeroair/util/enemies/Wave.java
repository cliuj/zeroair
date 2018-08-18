package zeroair.util.enemies;
import zeroair.actors.*;
import zeroair.actors.enemies.*;
import zeroair.util.enemies.movement.*;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;

public class Wave {

  ArrayList<Enemy> wave;

  private boolean sortie;
  private boolean completed;

  private long delay = 1000;
  private long lastUpdate;


  public Wave(int numOfEnemies, double posX, double posY, double tPosX, double tPosY, double width, double height, String sprite, double health, Movement movement, double speed) {
    wave = new ArrayList<>();
    sortie = true;
    init(numOfEnemies, posX, posY, tPosX, tPosY, width, height, sprite, health, movement, speed);
    lastUpdate = 0;
  }

  public void init(int numOfEnemies, double posX, double posY, double tPosX, double tPosY, double width, double height, String sprite, double health, Movement movement, double speed) {
    for(int i = 0; i < numOfEnemies; i++) {
      wave.add(new DCU_V2(posX, posY, tPosX, tPosY, width, height, sprite, health, movement, speed));
    }
  }

  public boolean getSortie() {
    return sortie;
  }

  public boolean getCompleted() {
    return completed;
  }

  public void checkCompleted() {
    if(wave.size() < 1) {
      completed = true;
    }
  }

  public ArrayList<Enemy> getWaveContents() {
    return wave;
  }

  public void update(long arg0) {
    for(Iterator<Enemy> iterator = wave.iterator(); iterator.hasNext();) {
      Enemy enemy = iterator.next();
      if(arg0 - lastUpdate >= delay) {
        enemy.update(arg0);
        lastUpdate = arg0;
      }
      if(enemy.isDead() || enemy.hasEscaped()) {
        iterator.remove();
        System.out.println("Deleted");
      }
    }
  }

  public void render(GraphicsContext graphicsContext) {
    for(Enemy enemy: wave) {
      enemy.render(graphicsContext);
    }
  }
}
