/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy;

import dev.macrobug.number.Point;
import java.util.ArrayList;
import org.macrobug.galaxy.visitor.AccelerationVisitor;

/**
 *
 * @author sadjehwty
 */
public class Newton {
  private final Shot s;
  private final ArrayList<Planet> list=new ArrayList<>();
  public Newton(Shot s){this.s=s;}
  
  public void addPlanet(Planet p){
    list.add(p);
  }
  
  public boolean tic(){
    double hz=java.lang.Double.parseDouble(Constant.get("physics.Hz"));
    AccelerationVisitor av=new AccelerationVisitor(s);
    for(Planet p:list)
      p.accept(av);
    Point a=(Point) av.getAcceleration();
    s.setPosition(s.getPosition().add(s.getVelocity().times(hz)).add(a.times(Math.pow(hz, 2)/2)));
    s.setVelocity(s.getVelocity().add(a.times(hz)));
    for(Planet p:list)
      if(p.isHit(s.getPosition())){
        p.hit(s); // TODO lo dovrebbe fare qualcun'altro
        return false;
      }
    // TODO se fuori dallo schermo false
    return true;
  }
}
