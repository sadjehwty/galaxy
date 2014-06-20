/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macrobug.galaxy;

import dev.macrobug.number.Point;
import dev.macrobug.number.Vector2d;
import org.macrobug.galaxy.visitor.Visitor;

/**
 *
 * @author sadjehwty
 */
public class Shot extends Grave {

  public Shot(Point a, Point o) {
    this(new Vector2d(a, o));
  }

  public Shot(Vector2d v) {
    super(true, v);
  }

  @Override
  public String toString() {
    return "(" + getPosition().toString() + ")";
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
