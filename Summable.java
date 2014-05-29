package dev.macrobug.galaxy.numeric;
public interface Summable{
  public Summable add(Summable);
  public Summable minus(Summable);
  public Summable complement();
}