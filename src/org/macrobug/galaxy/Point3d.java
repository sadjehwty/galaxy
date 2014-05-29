/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;
/**
 *
 * @author Manny
 */
public class Point3d{
    public double x,y,z;
    public Point3d(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public double getX(){return x;}
    public double getY(){return y;}
    public double getZ(){return z;}

    public void translate(double dx, double dy,double dz) {
        x+=dx;
        y+=dy;
        z+=dz;
    }
    @Override
    public Object clone(){
        return new Point3d(x,y,z);
    }

    public double distanceSq(Point3d position) {
        double dx=position.x-x;
        double dy=position.y-y;
        double dz=position.z-z;
        return dx*dx+dy*dy+dz*dz;
    }
}
