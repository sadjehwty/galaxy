/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.macrobug.galaxy;

import dev.macrobug.number.Point;
import dev.macrobug.number.Vector2d;
import org.macrobug.galaxy.visitor.Visitor;

/**
 *
 * @author sadjehwty
 * @param <P>
 * @param <N>
 */
public class Shot<P extends Point<N>, N extends dev.macrobug.number.Number> extends Grave<P, N> {

  public Shot(P a, P o) {
    this(new Vector2d<>(a, o));
  }

  public Shot(Vector2d<P> v) {
    super(true, v);
  }

  @Override
  public String toString() {
    return "(" + getPosition().toString() + ")";
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
