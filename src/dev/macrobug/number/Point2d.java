/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number;


public class Point2d extends Point {

  @Override
  public void translate(Point p) {
    Point2d t = add(p);
    x = t.getX();
    y = t.getY();
  }

  @Override
  public Point2d add(Point p) {
    return new Point2d(x.add(p.getX()), y.add(p.getY()));
  }

  @Override
  public Point2d sub(Point p) {
    return new Point2d(x.sub(p.getX()), y.sub(p.getY()));
  }

  @Override
  public Number distanceSq(Point position) {
    Number dx = position.getX().sub(getX());
    Number dy = position.getY().sub(getY());
    return  dx.times(dx).add(dy.times(dy));
  }

  @Override
  public Point2d diffPolar(Point p) {
    Number dx= getX().sub(p.getX());
    Number dy= getY().sub(p.getY());
    Number r= dx.pow(2).add(dy.pow(2)).pow(0.5);
    return new Point2d(r,dy.div(dx).atan());
  }

  @Override
  public Point2d depolar() {
    return new Point2d(getX().times(getY().cos()),getX().times(getY().sin()));
  }

  @Override
  public Point2d times(double d) {
    return new Point2d(getX().times(d),getY().times(d));
  }

  public Point2d(Point t) {
    super(t);
  }

  public Point2d(Number x, Number y) {
    super(x, y);
  }

  public Point2d() {
  }

  public Point2d(boolean rand) {
    super(rand);
  }
  
}
