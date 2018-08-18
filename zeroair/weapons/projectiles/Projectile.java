package zeroair.weapons.projectiles;

import zeroair.util.HitBox;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public class Projectile {

  private double velocity;
  private double border;

  private HitBox hitbox;
  private Image image;
  private double damage;

  private double posX;
  private double posY;

  private boolean fromPlayer;
  private boolean finish;

  private boolean debug;

  public Projectile(double posX, double posY, double width, double height, String sprite, double damage, double velocity, double border, boolean fromPlayer) {
    init(posX, posY, width, height, sprite, damage, velocity, border, fromPlayer);
  }

  private void init(double posX, double posY, double width, double height, String sprite, double damage, double velocity, double border, boolean fromPlayer) {
    this.posX = posX;
    this.posY = posY;
    this.damage = damage;
    this.velocity = velocity;
    this.border = border;
    this.fromPlayer = fromPlayer;

    hitbox = new HitBox(posX, posY, width, height);
    try {
      image = new Image(sprite);
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

  public HitBox getHitBox() {
    return hitbox;
  }

  public boolean finished() {
    return finish;
  }

  public void setFinished() {
    finish = true;
  }

  public double getDamage() {
    return damage;
  }

  public boolean isFromPlayer() {
    return fromPlayer;
  }

  public void update() {

    if(fromPlayer) {
      posY = posY - velocity;
      hitbox.setPosY(hitbox.getPosY() - velocity);
    } else {
      posY = posY + velocity;
      hitbox.setPosY(hitbox.getPosY() + velocity);
    }

    if(debug) {
      System.out.println("===================");
      hitbox.printSpecfics();
    }

    if(fromPlayer && posY < border) {
      finish = true;
    } else if (!fromPlayer && posY > border) {
      finish = true;
    }
  }

  public void render(GraphicsContext graphicsContext) {
    graphicsContext.drawImage(image, posX, posY);
  }
}
