/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number;


public abstract class Number{
  protected final double real;
  public Number(double value){
    real=value;
  }
  public abstract Number add(Number t);
  public abstract Number sub(Number t);
  public abstract Number times(Number t);
  public abstract Number times(double d);
  public abstract Number div(Number t);
  public abstract Number pow(double t);
  public abstract Number atan();
  public abstract Number log();
  public abstract Number sin();
  public abstract Number cos();
  public abstract Number rand();
  public double getReal(){return real;}
  public int toInt(){
    return (int) Math.round(real);
  }
}
