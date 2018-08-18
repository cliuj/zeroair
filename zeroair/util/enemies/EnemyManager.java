package zeroair.util.enemies;
import zeroair.actors.Player;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyManager {

  ArrayList<Wave> waveQueue;

  MovementManager movementManager;
  private int movementID;

  private long lastUpdate;

  private boolean change;
  
  public EnemyManager() {
    movementManager = new MovementManager();
    waveQueue = new ArrayList<>();
    init();
  }

  public void init() {
    movementID = 0;
    waveQueue.add(new Wave(5, -50, 100, 800, 100, 32, 32, "zeroair/assets/sprites/enemies/enemy.png", 3, movementManager.getMovement(movementID), 1));
    waveQueue.add(new Wave(5, 850, 200, -32, 100, 32, 32, "zeroair/assets/sprites/enemies/enemy.png", 3, movementManager.getMovement(movementID), -1));
    lastUpdate = 0;
  }

  public ArrayList<Wave> getWaveQueue() {
    return waveQueue;
  }

  public void update(long arg0) {
    // if(currentTime - startTime >= delay) {
    // System.out.println("EM passed");
    for(Iterator<Wave> iterator = waveQueue.iterator(); iterator.hasNext();) {
      Wave wave = iterator.next();
      if(wave.getSortie()) {
        wave.update(arg0);
        if(wave.getCompleted()) {
          iterator.remove();
        }
      }
    }
    if(arg0 - lastUpdate >= 1_000_000_000) {

      if(change == true) {
        waveQueue.add(new Wave(5, -50, 100, 800, 100, 32, 32, "zeroair/assets/sprites/enemies/enemy.png", 3, movementManager.getMovement(movementID), 1));
        change = false;
      } else if(change == false) {
        waveQueue.add(new Wave(5, 850, 200, -32, 100, 32, 32, "zeroair/assets/sprites/enemies/enemy.png", 3, movementManager.getMovement(movementID), -1));
        change = true;
      }
      lastUpdate = arg0;
    }
  }

  public void render(GraphicsContext graphicsContext) {
    for(Wave wave: waveQueue) {
      if(wave.getSortie()) {
        wave.render(graphicsContext);
      }
    }
  }
}
