package zeroair.actors.enemies;
import zeroair.actors.*;
import zeroair.weapons.*;
import zeroair.util.enemies.*;
import zeroair.util.enemies.movement.*;
import zeroair.weapons.projectiles.ProjectilePool;
import zeroair.util.Counter;


import javafx.scene.canvas.GraphicsContext;


// DCU-V2 stands for Dynamic Combat Unit Version 2
public class DCU_V2 extends Enemy {

  private Player player;
  private double hPosX;
  private double hPosY;
  private long delay = 150_000_000;

  public DCU_V2(double posX, double posY, double tPosX, double tPosY, double width, double height, String sprite, double health, Movement movement, double speed) {

    this.hPosX = posX;
    this.hPosY = posY;
    init(posX, posY, width, height, sprite, health);
    this.tPosX = tPosX;
    this.tPosY = tPosY;
    this.speed = speed;
    this.movement = movement;
    weapon = new Weapon(this, 4, 8, "zeroair/assets/sprites/projectiles/laser.png", 1, 1.3, 800, false);
    // System.out.println("DCU-V2 created");
  }

  public void update(long arg0) {
    if(health < 0) {
      Counter.counter++;
      dead = true;
    }
    checkStatus();

    checkEscaped();
    movement.executeMovement(this);

    weapon.setGunLocation(posX, posY);
    weapon.update(arg0, delay);
  }

  @Override
  public void render(GraphicsContext graphicsContext) {
      graphicsContext.drawImage(sprite, posX, posY);
  }
}
