/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.macrobug.number;

/**
 *
 * @author sadjewty
 * @param <T>
 */
public class Point3d<T extends Number> extends Point<T> {

  protected T z;
  
  public Point3d(){
    super();
    z=newType(0.0);
  }
  
  public Point3d(T x, T y, T z) {
    super(x, y);
    this.z = z;
  }

  public Point3d(Point<T> p) {
    super(p);
    z = newType(0);
  }
  public Point3d(Point3d<T> p){
    super(p);
    z=p.getZ();
  }
  
  public void setZ(T z){this.z=z;}
  public T getZ() {
    return z;
  }
  /*
   public void translate(T dx, T dy,T dz) {
   x=x.add(dx);
   y=y.add(dy);
   z=z.add(dz);
   }
   */

  @Override
  public void translate(Point<T> p) {
    Point3d<T> t = add(p);
    x = t.getX();
    y = t.getY();
    z = t.getZ();
  }
  
  @Override
  public Point3d<T> add(Point<T> p) {
    return add(new Point3d<>(p.getX(), p.getY(), newType(0.0)));
  }
  public Point3d<T> add(Point3d<T> p){
    return (Point3d<T>) new Point3d<>(x.add(p.getX()), y.add(p.getY()), z.add(p.getZ()));
  }

  @Override
  public T distanceSq(Point<T> position) {
    return distanceSq(new Point3d<>(position.getX(), position.getY(), newType(0.0)));
  }
  public T distanceSq(Point3d<T> position){
    T dx = (T) position.getX().sub(getX());
    T dy = (T) position.getY().sub(getY());
    T dz = (T) position.getZ().sub(getZ());
    return (T) dx.times(dx).add(dy.times(dy)).add(dz.times(dz));
  }
  
  /*
   public static <T extends Number<T>> Point3d<T> depolarize(T rho, T phi,T sigma){
   T q = rho.times(sigma.cos());
   return new Point3d(q.times(phi.cos()),q.times(phi.sin()),rho.times(sigma.sin()));
   }*/

  @Override
  public Point3d<T> depolar() {
    T q = (T) getX().times(getZ().cos());
    return (Point3d<T>) new Point3d<>(q.times(getY().cos()), q.times(getY().sin()), getX().times(getZ().sin()));
  }

  @Override
  public Point3d<T> sub(Point<T> p) {
    return sub(new Point3d<>(p.getX(), p.getY(), newType(0.0)));
  }
  public Point3d<T> sub(Point3d<T> p){
    return (Point3d<T>) new Point3d<>(x.sub(p.getX()), y.sub(p.getY()), z.sub(p.getZ()));
  }

  @Override
  public Point3d<T> clone_() {
    return new Point3d(this);
  }

  @Override
  public Point3d<T> polar(Point<T> p) {
    return polar(new Point3d<>(p.getX(), p.getY(), newType(0.0)));
  }
  public Point3d<T> polar(Point3d<T> p){
    T dx=(T) getX().sub(p.getX());
    T dy=(T) getY().sub(p.getY());
    T dz=(T) getZ().sub(p.getZ());
    T q=(T) dx.pow(2).add(dy.pow(2)).pow(0.5);
    T r=(T) q.pow(2).add(z.pow(2)).pow(0.5);
    return (Point3d<T>) new Point3d<>(r,dy.div(dx).atan(),dz.div(q).atan());
  }

  @Override
  public Point3d<T> times(double d) {
    return (Point3d<T>) new Point3d<>(getX().times(d),getY().times(d),getZ().times(d));
  }
}
