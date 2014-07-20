package dev.macrobug.number;

import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Complex extends Number{
  private final double imag;
  
  public static final Complex ZERO=new Complex(0);
  public static final Complex ONE=new Complex(1);
  public static final Complex I=new Complex(0,1);

  public double getImage(){return imag;}
  
  public double abs(){
    return Math.sqrt(Math.pow(real,2)+Math.pow(imag, 2));
  }
  public double arg(){
    return Math.atan2(imag, real);
  }
  
  public Complex(double real){
    this(real,0);
  }
  
  public Complex(double real,double imag){
    super(real);
    this.imag=imag;
  }
  
  @Override
  public Complex add(Number t) {
    return add(new Complex(t.real));
  }
  public Complex add(Complex t){
    return new Complex(t.real+real,((Complex)t).imag+imag);
  }
  
  @Override
  public Complex sub(Number t) {
    return sub(new Complex(t.real));
    
  }
  public Complex sub(Complex t){
    return new Complex(real-t.real,imag-((Complex)t).imag);
  }
  
  @Override
  public Complex times(Number t) {
    return times(t.real);
  }
  public Complex times(Complex t){
    return new Complex(real*t.real-imag*((Complex)t).imag,real*((Complex)t).imag+imag*t.real);
  }
  
  @Override
  public Complex div(Number t) {
    return times(1/t.real);
   }
  public Complex div(Complex t){
    double q=Math.pow(t.real,2)+Math.pow(((Complex)t).imag,2);
    return new Complex((real*t.real+imag*((Complex)t).imag)/q,(imag*t.real-real*((Complex)t).imag)/q);
  }
  
  @Override
  public Complex pow(double t) {
    return new Complex(Math.pow(abs(),t)*Math.cos(arg()*t),Math.pow(abs(),t)*Math.sin(arg()*t));
  }

  @Override
  public Complex atan() {
    Complex i=times(I);
    return ONE.sub(i).log().sub(ONE.add(i).log()).times(new Complex(0,0.5));
  }

  @Override
  public Complex log() {
    return new Complex(Math.log(abs()),arg());
  }
  
  @Override
  public Complex times(double d) {
    return new Complex(d*real,d*imag);
  }

  @Override
  public Complex sin() {
    double eb=Math.pow(Math.E, imag);
    double _eb=1/eb;
    Complex q=new Complex(_eb*Math.cos(real),_eb*Math.sin(real)).sub(new Complex(eb*Math.cos(-real),eb*Math.sin(-real)));
    return q.div(new Complex(0,2));
  }

  @Override
  public Complex cos() {
    double eb=Math.pow(Math.E, imag);
    double _eb=1/eb;
    Complex q=new Complex(_eb*Math.cos(real),_eb*Math.sin(real)).add(new Complex(eb*Math.cos(-real),eb*Math.sin(-real)));
    return q.div(new Complex(2,0));
  }
  
  @Override
  public String toString(){
    StringBuilder sb=new StringBuilder();
    sb.append('(');
    sb.append(real);
    if(imag>=0) sb.append('+');
    sb.append(imag);
    sb.append("i)");
    return sb.toString();
  }
  
  public static Complex rand(){
    return rand(java.lang.Double.MAX_VALUE);
  }
  public static Complex rand(double max){
    return rand(0,max);
  }
  public static Complex rand(double min, double max){
    Random r=new Random(System.currentTimeMillis());
    return new Complex(r.nextDouble()*max-min,r.nextDouble()*max-min);
  }
  
  public static Complex parse(String s){
    Pattern p=Pattern.compile("^((?<r>([-+]?(\\d+\\.?\\d*|\\d*\\.?\\d+)([Ee][-+]?[0-2]?\\d{1,2})?[r]?))|(?<i>([-+]?((\\d+\\.?\\d*|\\d*\\.?\\d+)([Ee][-+]?[0-2]?\\d{1,2})?)?[i]))|(?<r>([-+]?(\\d+\\.?\\d*|\\d*\\.?\\d+)([Ee][-+]?[0-2]?\\d{1,2})?[r]?))(?<i>([-+]((\\d+\\.?\\d*|\\d*\\.?\\d+)([Ee][-+]?[0-2]?\\d{1,2})?)?[i])))$");
    Matcher m=p.matcher(s);
    String real=m.group("r");
    String imag=m.group("i");
    return new Complex(java.lang.Double.parseDouble(real),java.lang.Double.parseDouble(imag));
  }
}
