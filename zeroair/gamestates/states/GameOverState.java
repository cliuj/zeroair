package zeroair.gamestates.states;
import zeroair.Launcher;
import zeroair.PlayWindow;
import zeroair.util.buttons.*;

import javafx.scene.Cursor;
import javafx.scene.canvas.GraphicsContext;

public class GameOverState implements State {

  NewGameButton newGame = new NewGameButton(352, 300, 96, 32, "zeroair/assets/texts/hovered.png", "zeroair/assets/texts/newgame.png");
  SettingsButton settings = new SettingsButton(352, 350, 96, 32, "zeroair/assets/texts/hovered.png", "zeroair/assets/texts/settings.png");
  RTMenuButton rToMenu = new RTMenuButton(352, 400, 96, 32, "zeroair/assets/texts/hovered.png", "zeroair/assets/texts/rtmenu.png");
  ExitButton exit = new ExitButton(352, 450, 96, 32, "zeroair/assets/texts/hovered.png", "zeroair/assets/texts/exit.png");

  public GameOverState() {
    System.out.println("GameOverState created");
  }

  public void init() {

  }

  public void processInput(double x, double y, boolean clicked, boolean escPressed) {
    newGame.processInput(x, y, clicked, escPressed);
    settings.processInput(x, y, clicked, escPressed);
    rToMenu.processInput(x, y, clicked, escPressed);
    exit.processInput(x, y, clicked, escPressed);
  }

  public void update(long arg0) {
    PlayWindow.setClicked(false);
    PlayWindow.setESCPressed(false);
    newGame.update();
    settings.update();
    rToMenu.update();
    exit.update();
  }

  public void render(GraphicsContext graphicsContext) {
    newGame.render(graphicsContext);
    settings.render(graphicsContext);
    rToMenu.render(graphicsContext);
    exit.render(graphicsContext);
  }

}
