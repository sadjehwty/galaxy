/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import static java.lang.Math.*;
import static org.macrobug.galaxy.Constant.*;

/**
 *
 * @author Manny
 */
public abstract class Grave implements Paintable{
    private final boolean moveble;
    private final double g;
    private final Vettore v;

    public Grave(boolean moveble, double gravity,Vettore v){
        this.moveble=moveble;
        this.g=gravity;
        this.v=v;
    }
    public Grave(boolean moveble,Vettore v){this(moveble,1,v);}

    public boolean movable(){return moveble;}
    public double getG(){return g;}
    public Vettore getVector(){return v;}
    public Point3d getPosition(){return v.getOrigin();}
    public Point3d getVelocity(){return v.getValue();}
    public double getX(){return getPosition().x;}
    public double getY(){return getPosition().y;}
    public double getZ(){return getPosition().z;}

    public Vettore getDistance(Grave g){
        double x=g.getPosition().x-getPosition().x;
        double y=g.getPosition().y-getPosition().y;
        double z=g.getPosition().z-getPosition().z;
        double q=sqrt(x*x+y*y);
        double rho=K*getG()*g.getG()/getPosition().distanceSq(g.getPosition());
        return new Vettore(Vettore.depolarize(rho,atan2(y, x),atan2(z, q)));
    }
}
