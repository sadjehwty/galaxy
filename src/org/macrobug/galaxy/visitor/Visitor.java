package org.macrobug.galaxy.visitor;

import org.macrobug.galaxy.*;

public interface Visitor {

  public void visit(Planet visit);
  public void visit(Shot visit);

}
