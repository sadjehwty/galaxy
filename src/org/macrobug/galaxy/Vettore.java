/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import static java.lang.Math.*;

/**
 *
 * @author Manny
 */
public class Vettore {
    private Point3d a,o;

    public Vettore(Point3d a,Point3d o){
        this.a=a;
        this.o=o;
    }
    public Vettore(Point3d o){
        this(new Point3d(0,0,0),o);
    }

    public Point3d getOrigin(){return a;}
    public Point3d getValue(){return o;}

    public Vettore add(Vettore v){
        Point3d p=(Point3d) o.clone();
        p.translate(v.getValue().x-v.getOrigin().x, v.getValue().y-v.getOrigin().y, v.getValue().z-v.getOrigin().z);
        return new Vettore(p);
    }
    public Vettore add_(Vettore v){
        o.translate(v.getValue().x-v.getOrigin().x, v.getValue().y-v.getOrigin().y, v.getValue().z-v.getOrigin().z);
        return this;
    }

    public static Point3d depolarize(double p,double o,double t){
        double q=p*cos(t);
        return new Point3d((int)round(q*cos(o)),(int)round(q*sin(o)),(int)round(p*sin(t)));
    }
    public static Point3d depolarize(double p,int o,int t){
        return depolarize(p,toRadians(o),toRadians(t));
    }
}
