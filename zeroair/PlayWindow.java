package zeroair;
import zeroair.gamestates.GameStateManager;
import zeroair.gamestates.states.PauseState;

import javafx.animation.AnimationTimer;

import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;

public class PlayWindow extends Pane {

  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;
  private double x = 0;
  private double y = 0;
  private static boolean clicked;
  private static boolean escPressed;
  private GameStateManager gsManager;
  private Canvas canvas = new Canvas(WIDTH, HEIGHT);
  private GraphicsContext graphicsContext;

  private static Image defaultBG = new Image("zeroair/assets/background/bg.png");
  private static Image stageBG;
  private static ImageView bgView = new ImageView(defaultBG);
  private static double bgScrollSpeed;

  public PlayWindow() {
    setPrefSize(WIDTH, HEIGHT);
    requestFocus();
    init();
  }

  public void init() {
    gsManager = new GameStateManager();
    graphicsContext = canvas.getGraphicsContext2D();
    getChildren().add(bgView);
    getChildren().add(canvas);
    run();
  }

  public void run() {
    AnimationTimer gameLoop = new AnimationTimer() {
      public void handle(long arg0) {

        if(gsManager.checkPlayState()) {
          scrollBG();
        }

        processInput();
        update(arg0);
        render();
      }
    };
    gameLoop.start();
  }

  public static int getWIDTH() {
    return WIDTH;
  }

  public static int getHEIGHT() {
    return HEIGHT;
  }

  public static void setClicked(boolean c) {
    clicked = c;
  }

  public static void setESCPressed(boolean esc) {
    escPressed = esc;
  }

  public static void revertMenuBG() {
    bgView.setImage(defaultBG);
    bgView.relocate(0,0);
  }

  public static void setStageBG(String sbg) {
    // System.out.println("bg: " + (-bgView.getImage().getHeight() + HEIGHT));
    stageBG = new Image(sbg);
    bgView.setImage(stageBG);
    bgView.relocate(0, -bgView.getImage().getHeight() + HEIGHT);
    bgScrollSpeed = 2;
    System.out.println("test");
  }

  public void scrollBG() {
    double bgY = bgView.getLayoutY() + bgScrollSpeed;
    if(Double.compare(bgY, 0) >= 0) {
      bgY = -1800;
    }
    bgView.setLayoutY(bgY);
  }

  public void processInput() {

    requestFocus();

    setOnMouseMoved( e -> {
      this.x = e.getX();
      this.y = e.getY();
    });

    setOnMouseClicked ( e -> {
      this.clicked = true;
    });

    setOnKeyPressed( e -> {
      switch(e.getCode()) {
        case ESCAPE:
        this.escPressed = true;
        System.out.println("escPressed: " + escPressed);
        break;
      }
    });

    gsManager.processInput(x, y, clicked, escPressed);
  }

  public void update(long arg0) {
    gsManager.update(arg0);
  }

  public void render() {
    graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
    gsManager.render(graphicsContext);
  }
}
