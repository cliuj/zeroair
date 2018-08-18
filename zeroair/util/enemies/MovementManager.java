package zeroair.util.enemies;
import zeroair.util.enemies.movement.*;

import java.util.ArrayList;

public class MovementManager {

  private ArrayList<Movement> movementList;
  private M1 m1;

  public MovementManager() {
    init();
  }

  public void init() {
    movementList = new ArrayList<>();
    m1 = new M1();
    movementList.add(m1);
  }

  public Movement getMovement(int patternID) {
    return movementList.get(patternID);
  }
}
