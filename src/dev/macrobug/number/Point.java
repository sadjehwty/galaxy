/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number;

import dev.macrobug.galaxy.factory.NumberFactory;

/**
 *
 * @author sadjehwty
 * @param <T>
 */
public abstract class Point{
  public abstract void translate(Point t);
  public abstract Point add(Point t);
  public abstract Point sub(Point t);
  public abstract Number distanceSq(Point t);
  protected Number x,y;
  public final void setX(Number x){this.x=x;}
  public final void setY(Number y){this.y=y;}
  public final Number getX(){return x;}
  public final Number getY(){return y;}
  public Point(Point t){
    x=t.getX();
    y=t.getY();
  }
  public Point(Number x, Number y){
    this.x=x;
    this.y=y;
  }
  public Point(){
    NumberFactory nf=new NumberFactory();
    x=nf.create(0.0);
    y=nf.create(0.0);
  }
  public Point(boolean rand){
    this();
    if(rand){
      x=getX().rand();
      y=getY().rand();
    }
  }
  public abstract Point diffPolar(Point p);
  public abstract Point depolar();
  public abstract Point times(double d);
}
