package zeroair.util.buttons;
import zeroair.gamestates.GameStateManager;
import zeroair.gamestates.states.PlayState;
import zeroair.gamestates.states.MenuState;


public class NewGameButton extends Button {
  public NewGameButton(double posX, double posY, double width, double height, String onHovered, String onIdle) {
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
      while(!(GameStateManager.peekState() instanceof MenuState)) {
        GameStateManager.popState();
      }
      GameStateManager.pushState(new PlayState());
    }
  }
}
