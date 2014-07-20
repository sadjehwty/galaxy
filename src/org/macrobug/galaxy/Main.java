/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macrobug.galaxy;

import dev.macrobug.number.factory.NumberFactory;
import dev.macrobug.number.factory.PointFactory;
import dev.macrobug.number.Number;
import dev.macrobug.number.Point;
import java.util.ArrayList;

/**
 *
 * @author sadjehwty
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayList<Planet> pianeti = new ArrayList<>();
    NumberFactory nf=new NumberFactory((Class<? extends Number>) Constant.getClass("math.number"));
    PointFactory pf=new PointFactory((Class<? extends Point>) Constant.getClass("math.point"),nf);
    for (int i = Constant.getInt("game.pianeti.numero"); i >= 0; i--) {
      Planet p = new Planet(pf);
      pianeti.add(p);
    }
    for (double p = 0; p < 10; p += .1) {
      for (int o = -90; o < 90; o++) {
        for (int t = -90; t < 90; t++) {
          Shot s = new Shot(new Point3d(0, HEIGTH / 2, DEPTH / 2), depolarize(p, o, t));
          System.out.println("------ Punti ------");
          do {
            System.out.println(s);
            for (Planet ps : pianeti) {
              s.getVector().translate(s.getDistance(ps));
            }
            s.getPosition().translate(s.getVelocity().x, s.getVelocity().y, s.getVelocity().z);
          } while (s.getPosition().x >= 0
                  && s.getPosition().y >= 0
                  && s.getPosition().x < WIDTH
                  && s.getPosition().y < HEIGTH
                  && s.getPosition().z < DEPTH
                  && (s.getVelocity().x != 0 || s.getVelocity().y != 0));
        }
      }
    }
    System.out.println("-------------------");
  }
}
