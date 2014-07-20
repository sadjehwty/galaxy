/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.macrobug.number;

import dev.macrobug.number.factory.PointFactory;

/**
 *
 * @author sadjehwty
 */
public class Vector2d {

  private Point a, o;
  private final PointFactory pf;

  public Vector2d(Point a, Point o) {
    this(o);
    this.a = a;
  }

  public Vector2d(Point o){
    this.o = o;
    pf=new PointFactory(o.getClass(),o.nf);
    a=pf.create();
  }
  public Point getOrigin() {
    return a;
  }

  public Point getValue() {
    return o;
  }

  public Vector2d add(Vector2d v) {
    Point p=pf.create(o);
    p.translate(v.getValue().sub(v.getOrigin()));
    return new Vector2d(p);
  }

  public Vector2d translate(Vector2d v) {
    o.translate(v.getValue().sub(v.getOrigin()));
    return this;
  }
}
