/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *@SuppressWarnings({"empty-statement})
 * @author Manny
 */
public class Constant {
  private static Properties prop;
  public static String getString(String s){
    return get(s);
  }
  public static Double getDouble(String s){
    return Double.parseDouble(get(s));
  }
  public static Integer getInt(String s){
    return Integer.parseInt(get(s));
  }
  public static Class<?> getClass(String s){
    try {
      return Class.forName(get(s));
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Constant.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(-1);
    }
    return null;
  }
  private static String get(String s){
    if(prop==null){
      prop=new Properties();
      InputStream input=null;
      try{
        String filename = "config.properties";
        input = Constant.class.getClassLoader().getResourceAsStream(filename);
        prop.load(input);
      }catch(IOException ioe){
        System.exit(-1);
      }finally{
        if(input!=null){
          try { input.close(); }
          catch (IOException e) {}
        }
      }
    }
    return prop.getProperty(s);
  }
}
