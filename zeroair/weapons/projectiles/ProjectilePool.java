package zeroair.weapons.projectiles;

import zeroair.weapons.projectiles.Projectile;

import java.util.ArrayList;
import java.util.Iterator;

public class ProjectilePool {

  public static ArrayList<Projectile> pool;

  public ProjectilePool() {
    pool = new ArrayList<>();
  }

  public void update() {
    // System.out.println(pool.size());
    for(Iterator<Projectile> iterator = pool.iterator(); iterator.hasNext();) {
      Projectile projectile = iterator.next();
      projectile.update();

      if(projectile.finished()) {
        iterator.remove();
      }
    }
  }
}
