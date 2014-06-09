/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import dev.macrobug.number.*;
import org.macrobug.galaxy.visitor.Visit;
/**
 *
 * @author sadjehwty
 * @param <P>
 * @param <N>
 */
public abstract class Grave<P extends Point<N>,N extends dev.macrobug.number.Number> implements Visit{
    private final boolean moveble;
    private final N g;
    private Vector2d<P> v;

    public Grave(boolean moveble, N gravity,Vector2d<P> v){
        this.moveble=moveble;
        this.g=gravity;
        this.v=v;
    }
    public Grave(boolean moveble,Vector2d<P> v){
      this(moveble,v.getOrigin().newType(0.0),v);
    }

    public boolean movable(){return moveble;}
    public N getG(){return g;}
    public Vector2d<P> getVector(){return v;}
    public P getPosition(){return v.getOrigin();}
    public P getVelocity(){return v.getValue();}
    public void setPosition(P p){v=new Vector2d<>(p,v.getValue());}
    public void setVelocity(P p){v=new Vector2d<>(v.getOrigin(),p);}
}
