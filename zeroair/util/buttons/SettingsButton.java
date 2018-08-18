package zeroair.util.buttons;
import zeroair.gamestates.GameStateManager;
import zeroair.gamestates.states.SettingsState;

public class SettingsButton extends Button {

  public SettingsButton(double posX, double posY, double width, double height, String onHovered, String onIdle) {
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
      GameStateManager.pushState(new SettingsState());
    }
  }
}
