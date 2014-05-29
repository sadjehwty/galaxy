/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import java.awt.*;
import static java.lang.Math.*;
import static org.macrobug.galaxy.Constant.*;
import org.macrobug.galaxy.visitor.Visit;
import org.macrobug.galaxy.visitor.Visitor;

/**
 *
 * @author Manny
 */
public class Planet extends Grave implements Visit{
    private final int r;
    private final double d;

    public Planet(double mass,int radius,Vettore p){
        super(false,p);
        this.r=radius;
        this.d=mass;
    }
    public Planet(){
        this(new Point3d(nextInt(WIDTH),nextInt(HEIGTH),nextInt(DEPTH)));
    }
    public Planet(Point3d p){this(new Vettore(p,new Point3d(0,0,0)));}
    public Planet(Vettore p){
        this(nextDouble(MAX_MASS),nextInt(MAX_RADIUS),p);
    }

    public double getMass(){return d;}
    public int getRadius(){return r;}

    @Override
    public double getG(){return d*r*r*PI;}

  @Override
    public void paint(Graphics g) {
        double c=0xffffff / MAX_MASS;
        g.setColor(new Color((int) (c * d)));
        g.fillOval((int)getPosition().x, (int)getPosition().y, r, r);
    }
    
    @Override
    public String toString(){
        return "[("+getX()+","+getY()+","+getZ()+"),"+getG()+"]";
    }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
