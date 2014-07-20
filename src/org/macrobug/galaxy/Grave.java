/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import dev.macrobug.number.factory.NumberFactory;
import dev.macrobug.number.*;
import org.macrobug.galaxy.visitor.Visit;
/**
 *
 * @author sadjehwty
 */
public abstract class Grave implements Visit{
    private final boolean moveble;
    private final dev.macrobug.number.Number g;
    private Vector2d v;

    public Grave(boolean moveble, dev.macrobug.number.Number gravity,Vector2d v){
        this.moveble=moveble;
        this.g=gravity;
        this.v=v;
    }
    public Grave(boolean moveble,Vector2d v){
      this(moveble,new NumberFactory().create(0.0),v);
    }

    public boolean movable(){return moveble;}
    public dev.macrobug.number.Number getG(){return g;}
    public Vector2d getVector(){return v;}
    public Point getPosition(){return v.getOrigin();}
    public Point getVelocity(){return v.getValue();}
    public void setPosition(Point p){v=new Vector2d(p,v.getValue());}
    public void setVelocity(Point p){v=new Vector2d(v.getOrigin(),p);}
}
