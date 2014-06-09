/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macrobug.galaxy;

import dev.macrobug.number.*;
import static java.lang.Math.*;
import java.util.Random;
import org.macrobug.galaxy.visitor.Visitor;

/**
 *
 * @author sadjehwty
 * @param <P>
 * @param <N>
 */
public class Planet<P extends Point<N>, N extends dev.macrobug.number.Number> extends Grave<P,N> {

  private final int r;
  private final N mass;

  public Planet(N mass, int radius, Vector2d<P> p) {
    super(false, p);
    this.r = radius;
    this.mass = mass;
  }

  public Planet() {
    this(new Vector2d<P>().newType(true));
  }

  public Planet(P p) {
    this(new Vector2d<>(p));
  }

  public Planet(Vector2d<P> p) {
    this(p.newType().newType(true), new Random(System.currentTimeMillis()).nextInt(), p);
  }

  public N getMass() {
    return mass;
  }

  public int getRadius() {
    return r;
  }

  @Override
  public N getG() {
    return (N) mass.times(r * r * PI);
  }

  @Override
  public String toString() {
    return "["+getPosition().toString()+","+getG()+"]";
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
