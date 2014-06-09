/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy.visitor;

import dev.macrobug.number.Point;
import org.macrobug.galaxy.Constant;
import org.macrobug.galaxy.Planet;
import org.macrobug.galaxy.Shot;


public class AccelerationVisitor implements Visitor {
  private Point s;
  
  public AccelerationVisitor(Shot s){this.s=s.getPosition();}
  
  public Point getAcceleration(){return s;}
  
  @Override
  public void visit(Planet visit) {
    dev.macrobug.number.Number distance=s.distanceSq(visit.getPosition());
    dev.macrobug.number.Number K=visit.getPosition().newType(java.lang.Double.parseDouble(Constant.get("physics.K")));
    dev.macrobug.number.Number a=K.times(visit.getG()).div(distance);
    Point polar=s.polar(visit.getPosition());
    polar.setX(a);
    s=polar.depolar();
  }

  @Override
  public void visit(Shot visit) {}
  
}
