package zeroair.util.buttons;

public class ExitButton extends Button {
  public ExitButton(double posX, double posY, double width, double height, String onHovered, String onIdle) {
    super();
    init(posX, posY, width, height, onHovered, onIdle);
  }

  @Override
  public void update() {
    if(hitbox.contacted(this.x, this.y)) {
      hovered = true;
    } else {
      hovered = false;
    }

    if(hovered && clicked) {
      System.exit(0);
    }
  }
}
