package zeroair.util.enemies.movement;

import zeroair.actors.Enemy;

// M1's patter is a straight path across the screen from the enemy's posX and posY
public class M1 extends Movement {

  public M1() {

  }

  @Override
  public void executeMovement(Enemy enemy) {
    enemy.setPosX(enemy.getPosX() + enemy.getSpeed());
    enemy.getHitBox().setPosX(enemy.getPosX());
  }

  // @Override
  // public double sPosX(int i, double posX) {
  //   return i * 50 + posX;
  // }
  //
  // @Override
  // public double sPosY(int i, double posY) {
  //   return posY;
  // }
}
