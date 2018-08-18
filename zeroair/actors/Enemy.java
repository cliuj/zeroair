package zeroair.actors;
import zeroair.weapons.projectiles.*;
import zeroair.util.enemies.movement.*;

import javafx.scene.canvas.GraphicsContext;

public abstract class Enemy extends Actor {

  protected boolean escaped;
  protected boolean finished;
  protected double speed;

  protected double tPosX;
  protected double tPosY;

  protected Movement movement;

  public Enemy() {

  }

  protected void checkEscaped() {
    if(posX == tPosX && posY == tPosY) {
      escaped = true;
    }
  }

  public double getSpeed() {
    return speed;
  }
  public boolean hasEscaped() {
    return escaped;
  }

  @Override
  public void checkStatus() {
    for(Projectile projectile: ProjectilePool.pool) {
      if(this.hitbox.contacted(projectile.getHitBox()) && projectile.isFromPlayer()) {
        projectile.setFinished();
        health = health - projectile.getDamage();
        System.out.println("Enemy hit!" + health);
      }
    }
  }
}
