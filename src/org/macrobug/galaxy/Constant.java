/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import java.util.Random;

/**
 *@SuppressWarnings({"empty-statement})
 * @author Manny
 */
public class Constant {
    public static final double K=.6;
    public static final int WIDTH=640;
    public static final int HEIGTH=480;
    public static final int DEPTH=480;
    public static final double MAX_MASS=100;
    public static final int MAX_RADIUS=50;
    public static final Random r=new Random(System.currentTimeMillis());
    public static int nextInt(int n){return r.nextInt(n);}
    public static double nextDouble(double d){return r.nextDouble()*d;}
}
