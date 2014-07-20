/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macrobug.galaxy;

import dev.macrobug.number.factory.NumberFactory;
import dev.macrobug.number.factory.PointFactory;
import dev.macrobug.number.*;
import static java.lang.Math.*;
import java.util.Random;
import org.macrobug.galaxy.visitor.Visitor;

/**
 *
 * @author sadjehwty
 */
public class Planet extends Grave {

  private final int r;
  private final dev.macrobug.number.Number mass;
  private final PointFactory pf;

  public Planet(PointFactory pf,dev.macrobug.number.Number mass, int radius, Vector2d p) {
    super(false, p);
    this.r = radius;
    this.mass = mass;
    this.pf=pf;
  }

  public Planet(PointFactory pf) {
    this(pf,pf.createRand());
  }

  public Planet(PointFactory pf,Point p) {
    this(pf,new Vector2d(p));
  }

  public Planet(PointFactory pf,Vector2d p) {
    this(pf,pf.getNumberFactory().createRand(), new Random(System.currentTimeMillis()).nextInt(), p);
  }

  public dev.macrobug.number.Number getMass() {
    return mass;
  }

  public int getRadius() {
    return r;
  }

  @Override
  public dev.macrobug.number.Number getG() {
    return mass.times(r * r * PI);
  }

  @Override
  public String toString() {
    return "["+getPosition().toString()+","+getG()+"]";
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
  
  public boolean isHit(Point p){
    return Math.floor(getPosition().distanceSq(p).pow(0.5).getReal())<=r;
  }
  public void hit(Shot s){
    /* TODO */
  }
}
