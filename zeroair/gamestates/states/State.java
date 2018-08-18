package zeroair.gamestates.states;

import javafx.scene.canvas.GraphicsContext;

public interface State {
  public void processInput(double x, double y, boolean clicked, boolean escPressed);
  public void update(long arg0);
  public void render(GraphicsContext graphicsContext);
}
