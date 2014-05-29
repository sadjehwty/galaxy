package org.macrobug.galaxy.visitor;

import org.macrobug.galaxy.Planet;

public interface Visitor {

  public void visit(Planet visit);

  public void visit(Visit visit);

}
