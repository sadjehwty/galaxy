/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.macrobug.number;

import dev.macrobug.number.factory.NumberFactory;

/**
 *
 * @author sadjewty */
public class Point3d extends Point {

  protected Number z;
  
  public Point3d(Number x, Number y, Number z) {
    super(x, y);
    this.z = z;
  }

  public Point3d(Point p) {
    super(p);
    z=nf.create(0.0);
  }
  public Point3d(Point3d p){
    super(p);
    z=p.getZ();
  }
  
  public void setZ(Number z){this.z=z;}
  public Number getZ() {
    return z;
  }
  
  @Override
  public void translate(Point p) {
    translate(new Point3d(p));
  }
  public void translate(Point3d p){
    Point3d t = add(p);
    x = t.getX();
    y = t.getY();
    z = t.getZ();
  }
  
  @Override
  public Point3d add(Point p) {
    return add(new Point3d(p.getX(), p.getY(), nf.create(0.0)));
  }
  public Point3d add(Point3d p){
    return new Point3d(x.add(p.getX()), y.add(p.getY()), z.add(p.getZ()));
  }

  @Override
  public Number distanceSq(Point position) {
    return distanceSq(new Point3d(position.getX(), position.getY(), nf.create(0.0)));
  }
  public Number distanceSq(Point3d position){
    Number dx = position.getX().sub(getX());
    Number dy = position.getY().sub(getY());
    Number dz = position.getZ().sub(getZ());
    return  dx.times(dx).add(dy.times(dy)).add(dz.times(dz));
  }
  
  @Override
  public Point3d depolar() {
    Number q =  getX().times(getZ().cos());
    return new Point3d(q.times(getY().cos()), q.times(getY().sin()), getX().times(getZ().sin()));
  }

  @Override
  public Point3d sub(Point p) {
    return sub(new Point3d(p.getX(), p.getY(), nf.create(0.0)));
  }
  public Point3d sub(Point3d p){
    return new Point3d(x.sub(p.getX()), y.sub(p.getY()), z.sub(p.getZ()));
  }

  @Override
  public Point3d diffPolar(Point p) {
    return diffPolar(new Point3d(p.getX(), p.getY(), nf.create(0.0)));
  }
  public Point3d diffPolar(Point3d p){
    Number dx= getX().sub(p.getX());
    Number dy= getY().sub(p.getY());
    Number dz= getZ().sub(p.getZ());
    Number q= dx.pow(2).add(dy.pow(2)).pow(0.5);
    Number r= q.pow(2).add(z.pow(2)).pow(0.5);
    return new Point3d(r,dy.div(dx).atan(),dz.div(q).atan());
  }

  @Override
  public Point3d times(double d) {
    return new Point3d(getX().times(d),getY().times(d),getZ().times(d));
  }
  
  public static Point3d rand(NumberFactory nf, double max){
    return rand(nf,0,max);
  }
  public static Point3d rand(NumberFactory nf, double min,double max){
    return new Point3d(nf.rand(min,max),nf.rand(min,max),nf.rand(min,max));
  }
}
