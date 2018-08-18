package zeroair.weapons;
import zeroair.gamestates.states.PlayState;
import zeroair.weapons.projectiles.*;
import zeroair.actors.*;

import javafx.scene.canvas.GraphicsContext;

// import java.util.ArrayList;
import java.util.Iterator;

public class Weapon {
  private double posX = 0;
  private double posY = 0;
  private boolean fromPlayer;
  private double width;
  private double height;
  private double damage;
  private double velocity;
  private double border;
  private String sprite;

  private long delay;
  private long lastUpdate;

  // private ArrayList<Projectile> projectiles = new ArrayList<>();
  private Actor owner;

  public Weapon(Actor owner, double width, double height, String sprite, double damage, double velocity, double border, boolean fromPlayer) {
    this.width = width;
    this.height = height;
    this.damage = damage;
    this.velocity = velocity;
    this.border = border;
    this.sprite = sprite;
    this.fromPlayer = fromPlayer;
    this.owner = owner;
    delay = 100_000_000;
    lastUpdate = 0;
  }

  public void setGunLocation(double x, double y) {
    posX = x;
    posY = y;
  }

  public void update(long arg0, long delay) {
    if(arg0 - lastUpdate >= delay) {
      ProjectilePool.pool.add(new Projectile(posX, posY, width, height, sprite, damage, velocity, border, fromPlayer));
      lastUpdate = arg0;
    }
  }

  public void render(GraphicsContext graphicsContext) {

  }
}
