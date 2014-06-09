/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import java.io.*;
import java.util.Properties;

/**
 *@SuppressWarnings({"empty-statement})
 * @author Manny
 */
public class Constant {
  private static Properties prop;
  public static String get(String s){
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
