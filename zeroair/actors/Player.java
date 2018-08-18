package zeroair.actors;
import zeroair.weapons.Weapon;
import zeroair.weapons.projectiles.*;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Player extends Actor {

  private Weapon[] weapons = new Weapon[4];
  private Image hitboxImage;
  private long delay = 150_000_000;

  public Player(double posX, double posY, double width, double height, String sprite, double health) {
    init(posX, posY, width, height, sprite, health);
    hitboxImage = new Image("zeroair/assets/sprites/player/hitbox.png");
    weapons[0] = new Weapon(this, 4, 8, "zeroair/assets/sprites/projectiles/laser2.png", 1, 2, 0, true);
    weapons[1] = new Weapon(this, 4, 8, "zeroair/assets/sprites/projectiles/laser2.png", 1, 2, 0, true);
    weapons[2] = new Weapon(this, 4, 8, "zeroair/assets/sprites/projectiles/laser2.png", 1, 2, 0, true);
    weapons[3] = new Weapon(this, 4, 8, "zeroair/assets/sprites/projectiles/laser2.png", 1, 2, 0, true);


  }

  public void processInput(double x, double y, boolean clicked, boolean escPressed) {
    this.posX = x - 15;
    this.posY = y - 15;
    this.hPosX = x;
    this.hPosY = y;
    hitbox.setPosX(hPosX);
    hitbox.setPosY(hPosY);

    hitbox.printSpecfics();
    weapons[0].setGunLocation(x - 8, y - 2);
    weapons[1].setGunLocation(x + 8, y - 2);
    weapons[2].setGunLocation(x - 15, y - 2);
    weapons[3].setGunLocation(x + 15, y - 2);

  }

  public void update(long arg0) {

    if(health < 1) {
      dead = true;
      System.out.println("Player died!");
    }

    checkStatus();

    weapons[0].update(arg0, delay);
    weapons[1].update(arg0, delay);
    weapons[2].update(arg0, delay);
    weapons[3].update(arg0, delay);
  }

  @Override
  public void render(GraphicsContext graphicsContext) {
    graphicsContext.drawImage(sprite, posX, posY);
    graphicsContext.drawImage(hitboxImage, hitbox.getPosX(), hitbox.getPosY());
  }
}
