package dev.macrobug.galaxy.number;
public class Coordinate<T extends Numeric> implements Summable{
  private T x;
  private T y;
  
  
  public T distance(T px, T py){
    return Coordinate.distance(x,y,px,py);
  }
  public static T distance(T x1, T y1, T x2, T y2){
    return Coordinate.distanceSq(x,y,px,py).sqrt();
  }
  public T distance(Coordinate<T> pt){
    return distance(pt.getX(),pt.getY());
  }
  public T distanceSq(T px, T py){
    return Coordinate.distanceSq(x,y,px,py);
  }
  public static T distanceSq(T x1, T y1, T x2, T y2){
    return x1.minus(x2).pow(2).add(y1.minus(y2).pow(2));
  }
  public T distanceSq(Coordinate<T> pt){
    return distanceSq(pt.getX(),pt.getY());
  }
  public T getX(){ return x;}
  public T getY(){ return y;}
  public void setLocation(T x, T y){
    this.x=x;
    this.y=y;
  }
  public void setLocation(Coordinate<T> p){
    setLocation(p.getX(),p.getY());
  }
  public void translate(T dx, T dy){
    setLocation(getX().add(dx),getY().add(dy));
  }
  public Coordinate<T> add(Coordinate<T> pt){
    Coordinate<T> temp=new Coordinate<T>(this);
    temp.translate(pt.getX(),pt.getY());
    return temp;
  }
  public Coordinate<T> minus(Coordinate<T> pt){
    return add(pt.complement());
  }
  public Coordinate<T> complement(){
    return new Coordinate<T>(getX().complement(),getY().complement());
  }
}