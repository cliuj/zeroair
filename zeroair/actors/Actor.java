package zeroair.actors;
import zeroair.util.HitBox;
import zeroair.weapons.Weapon;
import zeroair.weapons.projectiles.*;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public abstract class Actor {

  protected double posX = 0;
  protected double posY = 0;

  protected double health;
  protected HitBox hitbox;
  protected Image sprite;
  protected boolean dead;
  protected double hPosX;
  protected double hPosY;

  protected Weapon weapon;

  public Actor() {

  }

  protected void init(double posX, double posY, double width, double height, String sprite, double health) {
    this.posX = posX;
    this.posY = posY;
    this.health = health;
    hitbox = new HitBox(hPosX, hPosY, width, height);
    try {
      this.sprite = new Image(sprite);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public double getPosX() {
    return posX;
  }

  public double getPosY() {
    return posY;
  }

  public void setPosX(double posX) {
    this.posX = posX;
  }

  public void setPosY(double posY) {
    this.posY = posY;
  }

  public HitBox getHitBox() {
    return hitbox;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public boolean isDead() {
    return dead;
  }

  public void checkStatus() {
    for(Projectile projectile: ProjectilePool.pool) {
      if(this.hitbox.contacted(projectile.getHitBox()) && !projectile.isFromPlayer()) {
        projectile.setFinished();
        health = health - projectile.getDamage();
        System.out.println("Player hit!" + health);
      }
    }
  }

  public void update(long arg0) {

  }

  public void render(GraphicsContext graphicsContext) {

  }
}
