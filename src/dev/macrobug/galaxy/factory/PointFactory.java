/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.galaxy.factory;

import dev.macrobug.number.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.macrobug.galaxy.Constant;
/**
 *
 * @author sadjehwty
 */
public class PointFactory {
  private String klass;
  public PointFactory(){
    this(Constant.get("math.point"));
  }
  public PointFactory(String s){
    klass=s;
  }
  
  public Point create(){
    Point ret=null;
    try {
      Class<?> c=Class.forName(klass);
      ret=(Point) c.getConstructor().newInstance();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-3);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
  public Point createRand(){
    Point ret=null;
    try {
      Class<?> c=Class.forName(klass);
      ret=(Point) c.getConstructor(Boolean.class).newInstance(true);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-3);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
  public Point create(Point p){
    Point ret=null;
    try {
      Class<?> c=Class.forName(klass);
      ret=(Point) c.getConstructor(c).newInstance(p);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-3);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
}
