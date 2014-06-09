/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.macrobug.galaxy.visitor;

import java.awt.Color;
import java.awt.Graphics;
import org.macrobug.galaxy.Planet;
import org.macrobug.galaxy.Shot;

/**
 *
 * @author sadjehwty
 */
public class PaintVisitor implements Visitor{
  
  private Graphics g;
  public PaintVisitor(Graphics g){
    this.g=g;
  }
  
  @Override
  public void visit(Planet visit) {
    double c=0xffffff / MAX_MASS;
    g.setColor(new Color((int) (c * d)));
    g.fillOval((int)getPosition().x, (int)getPosition().y, r, r);
  }

  @Override
  public void visit(Shot visit) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
