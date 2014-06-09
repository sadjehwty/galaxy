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
    private final Vector2d<P> v;

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
/*
    public Vector2d<P> getDistance(Grave<P,N> g){
        T x=g.getPosition().x.sub(getPosition().x);
        T y=g.getPosition().y.sub(getPosition().y);
        T z=g.getPosition().z.sub(getPosition().z);
        T q=x.pow(2).add(y.pow(2)).pow(0.5);
        double K=java.lang.Double.parseDouble(Constant.get("physics.K"));                
        Vector2d ret=null;
      try {
        ret=new Vector2d(Point3d.depolarize(getG().times(g.getG()).times(K).div(getPosition().distanceSq(g.getPosition())),y.div(x).atan(),z.div(q).atan()));
      } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        Logger.getLogger(Grave.class.getName()).log(Level.SEVERE, null, ex);
      }
      return ret;
    }*/
}
