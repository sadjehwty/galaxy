/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number.factory;

import dev.macrobug.number.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sadjehwty
 */
public class PointFactory {
  private final Class<? extends Point> klass;
  private final NumberFactory nf;
  public PointFactory(Class<? extends Point> k,NumberFactory nf){
    klass=k;
    this.nf=nf;
  }
  public PointFactory(String s,NumberFactory nf) throws ClassNotFoundException{
    this((Class<? extends Point>)Class.forName(s),nf);
  }
  public Point create(){
    Point ret=null;
    try {
      ret=(Point) klass.getConstructor(NumberFactory.class).newInstance(nf);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
  public Point rand(){
    Point ret=null;
    try {
      ret=(Point) klass.getConstructor(Boolean.class).newInstance(true);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
  public Point create(Point p){
    Point ret=null;
    try {
      ret=(Point) klass.getConstructor(p.getClass()).newInstance(p);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException | IllegalArgumentException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
  
  public NumberFactory getNumberFactory(){return nf;}
  
  public Point parse(String s){
    try {
      return (Point) klass.getDeclaredMethod("parse", String.class).invoke(null, s);
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return null;
  }
}
