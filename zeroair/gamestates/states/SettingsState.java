package zeroair.gamestates.states;

import zeroair.PlayWindow;
import zeroair.util.buttons.*;

import javafx.scene.canvas.GraphicsContext;

public class SettingsState implements State {
  BackButton back = new BackButton(352, 400, 96, 32, "zeroair/assets/texts/hovered.png", "zeroair/assets/texts/return.png");

  public SettingsState() {
    System.out.println("SettingsState created");
  }

  public void processInput(double x, double y, boolean clicked, boolean escPressed) {
    back.processInput(x, y, clicked, escPressed);
  }

  public void update(long arg0) {
    back.update();
    PlayWindow.setClicked(false);
    PlayWindow.setESCPressed(false);
  }

  public void render(GraphicsContext graphicsContext) {
    back.render(graphicsContext);
  }
}
