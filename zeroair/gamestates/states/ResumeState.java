package zeroair.gamestates.states;
import zeroair.Launcher;
import zeroair.PlayWindow;
import zeroair.gamestates.GameStateManager;

import javafx.scene.Cursor;
import javafx.scene.canvas.GraphicsContext;

public class ResumeState implements State {

  private PlayState playState;
  private double posX = 0;
  private double posY = 0;
  private boolean clicked;

  public ResumeState(PlayState playState) {
    this.playState = playState;
    System.out.println("ResumeState created");
    // System.out.println("Player x: " + playState.getPlayer().getPosX() + " y: " + playState.getPlayer().getPosY());
    // playState.getPlayer().getHitBox().printSpecfics();
  }

  public void processInput(double x, double y, boolean clicked, boolean escPressed) {
    // System.out.println("Mouse x: " + posX + " y: " + posY);
    posX = x;
    posY = y;
    this.clicked = clicked;
  }

  public void update(long arg0) {
    PlayWindow.setClicked(false);
    PlayWindow.setESCPressed(false);

    if(playState.getPlayer().getHitBox().contacted(posX, posY) && clicked) {
      System.out.println(true);
      GameStateManager.popState();
      Launcher.scene.setCursor(Cursor.NONE);
    }
  }

  public void render(GraphicsContext graphicsContext) {
    playState.render(graphicsContext);
  }
}
