/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number.factory;

import dev.macrobug.number.Complex;
import dev.macrobug.number.Double;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dev.macrobug.number.Number;
import dev.macrobug.number.Number;
import dev.macrobug.number.Point;
import java.util.Random;
import java.util.StringTokenizer;
/**
 *
 * @author sadjehwty
 */
public class NumberFactory {
  private final Class<? extends Number> klass;
  public NumberFactory(Class<? extends Number> k){
    klass=k;
  }
  public NumberFactory(String s) throws ClassNotFoundException{
    this((Class<? extends Number>)Class.forName(s));
  }
  public Number create(double d){
    Number ret=null;
    try {
      ret=(Number) klass.getConstructor(Double.class).newInstance(d);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(NumberFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
  
  public Number rand(){
    return rand(java.lang.Double.MAX_VALUE);
  }
  public Number rand(double max){
    return rand(0,max);
  }
  public Number rand(double min, double max){
    try {
      return (Number) klass.getDeclaredMethod("rand", Double.class,Double.class).invoke(null, min,max);
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return create(0);
  }
  
  public Number parse(String s){
    try {
      return (Number) klass.getDeclaredMethod("parse", String.class).invoke(null, s);
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(PointFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return null;
  }
}
