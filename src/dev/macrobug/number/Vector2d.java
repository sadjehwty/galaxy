/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.macrobug.number;

import dev.macrobug.galaxy.factory.PointFactory;

/**
 *
 * @author sadjehwty
 */
public class Vector2d {

  private final Point a, o;

  public Vector2d(Point a, Point o) {
    this.a = a;
    this.o = o;
  }

  public Vector2d(Point o){
    this.o=o;
    PointFactory pf=new PointFactory();
    a=pf.create();
  }
  
  public Vector2d(){
    PointFactory pf=new PointFactory();
    o=pf.create();
    a=pf.create();
  }
  
  public Point getOrigin() {
    return a;
  }

  public Point getValue() {
    return o;
  }

  public Vector2d add(Vector2d v) {
    PointFactory pf=new PointFactory();
    Point p=pf.create(o);
    p.translate(v.getValue().sub(v.getOrigin()));
    return new Vector2d(p);
  }

  public Vector2d translate(Vector2d v) {
    o.translate(v.getValue().sub(v.getOrigin()));
    return this;
  }
}
