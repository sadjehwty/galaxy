package dev.macrobug.number;
public class Double extends Number{
  public static final Double ZERO=new Double(0);
  
  public Double(double real) {
    super(real);
  }
  
  @Override
  public Double add(Number t) {
    return new Double(real+t.real);
  }

  @Override
  public Double sub(Number t) {
    return new Double(real-t.real);
  }

  @Override
  public Double times(Number t) {
    return new Double(real*t.real);
  }

  @Override
  public Double pow(double t) {
    return new Double(Math.pow(real, t));
  }

  @Override
  public Double atan() {
    return new Double(Math.atan(real));
  }

  @Override
  public Double div(Number t) {
    return new Double(real/t.real);
  }

  @Override
  public Double log() {
    return new Double(Math.log(real));
  }
  
  @Override
  public Double times(double d) {
    return new Double(d*real);
  }

  @Override
  public Double sin() {
    return new Double(Math.sin(real));
  }

  @Override
  public Double cos() {
    return new Double(Math.cos(real));
  }
  
  @Override
  public String toString(){return real+"";}
}
