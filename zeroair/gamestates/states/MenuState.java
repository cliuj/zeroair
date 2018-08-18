package zeroair.gamestates.states;

import zeroair.PlayWindow;
import zeroair.util.buttons.*;

import javafx.scene.canvas.GraphicsContext;

public class MenuState implements State {

  NewGameButton newGame = new NewGameButton(352, 300, 96, 32, "zeroair/assets/texts/hovered.png", "zeroair/assets/texts/newgame.png");
  SettingsButton settings = new SettingsButton(352, 350, 96, 32, "zeroair/assets/texts/hovered.png", "zeroair/assets/texts/settings.png");
  ExitButton exit = new ExitButton(352, 400, 96, 32, "zeroair/assets/texts/hovered.png", "zeroair/assets/texts/exit.png");

  public MenuState() {
    System.out.println("MenuState created");
  }

  public void processInput(double x, double y, boolean clicked, boolean escPressed) {
    newGame.processInput(x, y, clicked, escPressed);
    settings.processInput(x, y, clicked, escPressed);
    exit.processInput(x, y, clicked, escPressed);
  }

  public void update(long arg0) {
    newGame.update();
    settings.update();
    exit.update();
    PlayWindow.setClicked(false);
    PlayWindow.setESCPressed(false);
  }

  public void render(GraphicsContext graphicsContext) {
    newGame.render(graphicsContext);
    settings.render(graphicsContext);
    exit.render(graphicsContext);
  }
}
