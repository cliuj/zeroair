package zeroair.util.buttons;
import zeroair.util.HitBox;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public abstract class Button {
  private Image onHovered;
  private Image onIdle;

  private double posX;
  private double posY;

  protected double x = 0;
  protected double y = 0;

  protected boolean clicked;
  protected boolean hovered;

  protected HitBox hitbox;

  public Button() {

  }

  public boolean getHovered() {
    return hovered;
  }

  public boolean getClicked() {
    return clicked;
  }

  public void init(double posX, double posY, double width, double height, String onHovered, String onIdle) {
    this.posX = posX;
    this.posY = posY;
    this.hitbox = new HitBox(posX, posY, width, height);
    try {
      this.onHovered = new Image(onHovered);
      this.onIdle = new Image(onIdle);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  public void processInput(double x, double y, boolean clicked, boolean escPressed) {
    this.x = x;
    this.y = y;
    this.clicked = clicked;
  }

  public void update() {
    if(hitbox.contacted(this.x, this.y)) {
      hovered = true;
    } else {
      hovered = false;
    }
  }

  public void render(GraphicsContext graphicsContext) {
    if(hovered) {
      graphicsContext.drawImage(onHovered, posX, posY);
    } else {
      graphicsContext.drawImage(onIdle, posX, posY);
    }
  }
}
