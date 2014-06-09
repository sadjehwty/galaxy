/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sadjehwty
 * @param <T>
 */
public abstract class Point<T extends Number> {
  public abstract void translate(Point<T> t);
  public abstract Point add(Point<T> t);
  public abstract Point sub(Point<T> t);
  public abstract T distanceSq(Point<T> t);
  protected T x,y;
  public final T getX(){return x;}
  public final T getY(){return y;}
  public Point(Point<T> t){
    x=t.getX();
    y=t.getY();
  }
  public Point(T x, T y){
    this.x=x;
    this.y=y;
  }
  public Point(){
    x=newType(0.0);
    y=newType(0.0);
  }
  public Point(boolean rand){
    this();
    if(rand){
      x=(T) getX().rand();
      y=(T) getY().rand();
    }
  }
  public final T newType(double d) {
    ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
    T ret = null;
    try {
      ret = ((Class<T>) paramType.getActualTypeArguments()[0]).getConstructor(java.lang.Double.class).newInstance(d);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(Point.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ret;
  }
  public final T newType(boolean rand) {
    ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
    T ret = null;
    try {
      ret = ((Class<T>) paramType.getActualTypeArguments()[0]).getConstructor(java.lang.Boolean.class).newInstance(rand);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(Point.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ret;
  }
  
  public abstract Point<T> clone_();
}
