/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.macrobug.number;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sadjehwty
 * @param <T>
 */
public class Vector2d<T extends Point> {

  private final T a, o;

  public Vector2d(T a, T o) {
    this.a = a;
    this.o = o;
  }

  public Vector2d(T o){
    this.o=o;
    a=newType();
  }
  
  public Vector2d(){
    o=newType();
    a=newType();
  }
  
  public T getOrigin() {
    return a;
  }

  public T getValue() {
    return o;
  }

  public Vector2d add(Vector2d<T> v) {
    T p = (T) o.clone_();
    p.translate(v.getValue().sub(v.getOrigin()));
    return new Vector2d(p);
  }

  public Vector2d add_(Vector2d<T> v) {
    o.translate(v.getValue().sub(v.getOrigin()));
    return this;
  }
  
  public final T newType() {
    ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
    T ret = null;
    try {
      ret = ((Class<T>) paramType.getActualTypeArguments()[0]).getConstructor().newInstance();
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
}
