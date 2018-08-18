package zeroair.gamestates;

import zeroair.gamestates.states.*;

import javafx.scene.canvas.GraphicsContext;

import java.util.Stack;

public class GameStateManager {

  public static Stack<State> stateStack = new Stack<>();

  public GameStateManager() {
    pushState(new MenuState());
    System.out.println(stateStack.peek() instanceof PlayState);
  }

  public static void pushState(State state) {
    stateStack.push(state);
  }

  public static void popState() {
    stateStack.pop();
  }

  public static State peekState() {
    return stateStack.peek();
  }

  public static void processInput(double x, double y, boolean clicked, boolean escPressed) {
    stateStack.peek().processInput(x, y, clicked, escPressed);
  }

  public static void update(long arg0) {
    stateStack.peek().update(arg0);
  }

  public static void render(GraphicsContext graphicsContext) {
    stateStack.peek().render(graphicsContext);
  }

  public static boolean checkPlayState() {
    if(stateStack.peek() instanceof PlayState) {
      return true;
    } else {
      return false;
    }
  }
}
