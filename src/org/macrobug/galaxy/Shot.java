/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import java.awt.Graphics;

/**
 *
 * @author Manny
 */
public class Shot extends Grave{

    public Shot(Point3d a,Point3d o){this(new Vettore(a,o));}
    public Shot(Vettore v){super(true,v);}
    
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public String toString(){
        return "("+getPosition().x+","+getPosition().y+","+getPosition().z+")";
    }
}
