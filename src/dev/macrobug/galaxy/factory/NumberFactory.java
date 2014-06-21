/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.galaxy.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.macrobug.galaxy.Constant;
import dev.macrobug.number.Number;
/**
 *
 * @author sadjehwty
 */
public class NumberFactory {
  private String klass;
  public NumberFactory(){
    this(Constant.get("math.number"));
  }
  public NumberFactory(String s){
    klass=s;
  }
  public Number create(double d){
    Number ret=null;
    try {
      Class<?> c=Class.forName(klass);
      ret=(Number) c.getConstructor(Double.class).newInstance(d);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(NumberFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-3);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(NumberFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
  public Number createRand(){
    Number ret=null;
    try {
      Class<?> c=Class.forName(klass);
      ret=(Number) c.getConstructor(Boolean.class).newInstance(true);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(NumberFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-3);
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(NumberFactory.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-2);
    }
    return ret;
  }
}
