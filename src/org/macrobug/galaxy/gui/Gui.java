/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macrobug.galaxy.gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.macrobug.galaxy.*;
import org.macrobug.galaxy.visitor.PaintVisitor;

public class Gui {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    final Class<dev.macrobug.number.Number<?>> klass;
    try {
      klass=(Class<dev.macrobug.number.Number<?>>)Class.forName(Constant.get("math.class"));
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    final ArrayList<Planet<klass>> pianeti = new ArrayList<>();
    final ArrayList<ArrayList<Point3d<klass>>> punti = new ArrayList<>();
    final int WIDTH=Integer.parseInt(Constant.get("gui.WIDTH"));
    final int HEIGTH=Integer.parseInt(Constant.get("gui.HEIGTH"));
    JFrame frame = new JFrame("Space");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH,HEIGTH);
    JPanel panel = new JPanel() {
      @Override
      public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGTH);
        PaintVisitor paint=new PaintVisitor(g);
        for (Planet p : pianeti) {
          p.accept(paint);
        }
        g.setColor(Color.WHITE);
        for (ArrayList<Point3d<klass>> l : punti) {
          for (int i = 0; i < l.size() - 1; i++) {
            Point3d<klass> t = l.get(i), n = l.get(i + 1);
            g.drawLine((int)t.x, (int)t.y, (int)n.x, (int)n.y);
          }
        }
      }
    };
    frame.setContentPane(panel);
    for (int i = nextInt(14) + 2; i >= 0; i--) {
      Planet p = new Planet();
      pianeti.add(p);
    }
    frame.setVisible(true);
    for (double p = 0; p < 10; p += .1) {
      for (int o = -90; o < 90; o++) {
        for (int t = -90; t < 90; t++) {
          Shot s = new Shot(new Point3d(0, HEIGTH / 2, DEPTH / 2), depolarize(p, o, t));
          ArrayList<Point3d> v = new ArrayList<>();
          v.add((Point3d) s.getPosition().clone());
          do {
            for (Planet ps : pianeti) {
              s.getVector().add_(s.getDistance(ps));
            }
            s.getPosition().translate(s.getVelocity().x, s.getVelocity().y, s.getVelocity().z);
            v.add((Point3d) s.getPosition().clone());
          } while (s.getPosition().x >= 0
                  && s.getPosition().y >= 0
                  && s.getPosition().x < WIDTH
                  && s.getPosition().y < HEIGTH
                  && s.getPosition().z < DEPTH
                  && (s.getVelocity().x != 0 || s.getVelocity().y != 0 || s.getVelocity().z != 0));
          punti.add(v);
        }
      }
    }
  }
}
