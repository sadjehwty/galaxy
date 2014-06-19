/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macrobug.galaxy.gui;

import java.util.ArrayList;
import org.macrobug.galaxy.*;

/**
 *
 * @author Manny
 */
public class Cli {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayList<Planet> pianeti = new ArrayList<>();
    System.out.println("----- Pianeti -----");
    for (int i = nextInt(14) + 2; i >= 0; i--) {
      Planet p = new Planet();
      System.out.println(p);
      pianeti.add(p);
    }
    System.out.println("-------------------");
    for (double p = 0; p < 10; p += .1) {
      for (int o = -90; o < 90; o++) {
        for (int t = -90; t < 90; t++) {
          Shot s = new Shot(new Point3d(0, HEIGTH / 2, DEPTH / 2), depolarize(p, o, t));
          System.out.println("------ Punti ------");
          do {
            System.out.println(s);
            for (Planet ps : pianeti) {
              s.getVector().add_(s.getDistance(ps));
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
