package zeroair;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;


public class Launcher extends Application {

  public static Scene scene;

  public void start(Stage stage) {
    stage.setTitle("Zero Air");

    PlayWindow playWindow = new PlayWindow();
    scene = new Scene(playWindow);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
