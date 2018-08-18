package zeroair.util.buttons;
import zeroair.gamestates.GameStateManager;
import zeroair.gamestates.states.State;
import zeroair.gamestates.states.ResumeState;
import zeroair.gamestates.states.PauseState;
import zeroair.gamestates.states.PlayState;

public class BackButton extends Button {
  public BackButton(double posX, double posY, double width, double height, String onHovered, String onIdle) {
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
      GameStateManager.popState();
    }
  }

  public void update(State state, PlayState playState) {
    if(hitbox.contacted(this.x, this.y)) {
      hovered = true;
    } else {
      hovered = false;
    }

    if(hovered && clicked && state instanceof PauseState) {
      GameStateManager.popState();
      GameStateManager.pushState(new ResumeState(playState));
    }
  }
}
