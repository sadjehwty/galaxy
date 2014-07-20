/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number;

import dev.macrobug.number.factory.NumberFactory;


public class Point2d extends Point {

  public Point2d(Point2d t) {
    super(t);
  }
  public Point2d(NumberFactory nf){
    super(nf);
  }
  public Point2d(Number x,Number y){
    super(x,y);
  }
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
    Number r= distanceSq(p).pow(0.5);
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

  public static Point2d rand(NumberFactory nf, double max){
    return rand(nf,0,max);
  }
  public static Point2d rand(NumberFactory nf, double min,double max){
    return new Point2d(nf.rand(min,max),nf.rand(min,max));
  }
}
