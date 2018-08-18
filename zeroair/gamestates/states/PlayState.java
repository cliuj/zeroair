package zeroair.gamestates.states;
import zeroair.Launcher;
import zeroair.PlayWindow;
import zeroair.actors.*;
import zeroair.actors.enemies.*;
import zeroair.util.enemies.*;
import zeroair.gamestates.GameStateManager;
import zeroair.weapons.projectiles.*;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayState implements State {

  private Player player;

  // ArrayList<Enemy> enemies = new ArrayList<>();
  private boolean escPressed;

  ProjectilePool pool;
  EnemyManager enemyManager;

  private long startTime;
  private long pausedDifference;
  private long currentTime;
  private long delay = 200_000_000;

  public PlayState() {
    System.out.println("PlayState created");
    init();
  }

  public void init() {
    Launcher.scene.setCursor(Cursor.NONE);
    PlayWindow.setStageBG("zeroair/assets/background/ribbon.png");
    player = new Player(400, 300, 3, 7, "zeroair/assets/sprites/player/jet.png", 3);
    pool = new ProjectilePool();
    enemyManager = new EnemyManager();
  }


  public Player getPlayer() {
    return player;
  }

  public void processInput(double x, double y, boolean clicked, boolean escPressed) {
    player.processInput(x, y, clicked, escPressed);
    this.escPressed = escPressed;
  }

  public void update(long arg0) {

    // calls player.update method
    player.update(arg0);

    // if Player isDead then remove PlayState and push GameOverState
    if(player.isDead()) {
      Launcher.scene.setCursor(Cursor.DEFAULT);
      GameStateManager.popState();
      GameStateManager.pushState(new GameOverState());
    }

    // for(Enemy enemy: enemies) {
    //   enemy.update(arg0);
    // }

    enemyManager.update(arg0);
    pool.update();

    // resets PlayWindow's setESCPressed boolean back to false
    PlayWindow.setESCPressed(false);

    // pauses the game if escape key is pressed
    if(escPressed) {
      pausedDifference = currentTime - startTime;

      Launcher.scene.setCursor(Cursor.DEFAULT);
      GameStateManager.pushState(new PauseState(this));
    }
  }

  // renders the player and all enemies stored in the wave
  // ordered by update calls
  public void render(GraphicsContext graphicsContext) {

    player.render(graphicsContext);

    for(Projectile projectile: ProjectilePool.pool) {
      projectile.render(graphicsContext);
    }
    enemyManager.render(graphicsContext);
    // for(Enemy enemy: enemies) {
    //   enemy.render(graphicsContext);
    // }
  }
}
