package zeroair.util;

public class HitBox {
  private double posX;
  private double posY;

  private double width;
  private double height;

  public HitBox(double posX, double posY, double width, double height) {
    this.posX = posX;
    this.posY = posY;
    this.width = width;
    this.height = height;
  }

  public void printSpecfics() {
    System.out.println("HitBox specifics: \nposX: " + posX + "\nposY: " + posY + "\nwidth: " + width + "\nheight: " + height);
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

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public boolean contacted (double x, double y) {
    if (posX <= x && x <= (posX + width) && posY <= y && y <= (posY + height)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean contacted(HitBox hitbox) {
    // AABB collision
    if(posX <= (hitbox.posX + hitbox.width) && (posX + width) >= hitbox.posX && posY <= (hitbox.posY + hitbox.height) && (posY + height) >= hitbox.posY) {
      return true;
    } else {
      return false;
    }
  }
}
