/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sadjehwty
 */
public class DoubleTest {
  private Random r;
  public DoubleTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
    r=new Random(System.currentTimeMillis());
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of add method, of class Double.
   */
  @Test
  public void testAdd() {
    System.out.println("add");
    double n=r.nextDouble();
    double m=r.nextDouble();
    Double a=new Double(n);
    Double b=new Double(m);
    Double expResult = new Double(n+m);
    Double result = a.add(b);
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of sub method, of class Double.
   */
  @Test
  public void testSub() {
    System.out.println("sub");
    double n=r.nextDouble();
    double m=r.nextDouble();
    Double a=new Double(n);
    Double b=new Double(m);
    Double expResult = new Double(n-m);
    Double result = a.sub(b);
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of times method, of class Double.
   */
  @Test
  public void testTimes_Number() {
    System.out.println("times");
    double n=r.nextDouble();
    double m=r.nextDouble();
    Double a=new Double(n);
    Double b=new Double(m);
    Double expResult = new Double(n*m);
    Double result = a.times(b);
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of pow method, of class Double.
   */
  @Test
  public void testPow() {
    System.out.println("pow");
    double n=r.nextDouble();
    double m=r.nextDouble();
    Double a=new Double(n);
    Double expResult = new Double(Math.pow(n,m));
    Double result = a.pow(m);
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of atan method, of class Double.
   */
  @Test
  public void testAtan() {
    System.out.println("atan");
    double n=r.nextDouble();
    Double a=new Double(n);
    Double expResult = new Double(Math.atan(n));
    Double result = a.atan();
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of div method, of class Double.
   */
  @Test
  public void testDiv() {
    System.out.println("div");
    double n=r.nextDouble();
    double m=r.nextDouble();
    Double a=new Double(n);
    Double b=new Double(m);
    Double expResult = new Double(n/m);
    Double result = a.div(b);
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of log method, of class Double.
   */
  @Test
  public void testLog() {
    System.out.println("log");
    double n=r.nextDouble();
    Double a=new Double(n);
    Double expResult = new Double(Math.log(n));
    Double result = a.log();
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of times method, of class Double.
   */
  @Test
  public void testTimes_double() {
    System.out.println("times");
    double n=r.nextDouble();
    double m=r.nextDouble();
    Double a=new Double(n);
    Double expResult = new Double(n*m);
    Double result = a.times(m);
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of sin method, of class Double.
   */
  @Test
  public void testSin() {
    System.out.println("sin");
    double n=r.nextDouble();
    Double a=new Double(n);
    Double expResult = new Double(Math.sin(n));
    Double result = a.sin();
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of cos method, of class Double.
   */
  @Test
  public void testCos() {
    System.out.println("cos");
    double n=r.nextDouble();
    Double a=new Double(n);
    Double expResult = new Double(Math.cos(n));
    Double result = a.cos();
    assertEquals(expResult.getReal(), result.getReal(),0.0);
  }

  /**
   * Test of toString method, of class Double.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    double n=r.nextDouble();
    Double a=new Double(n);
    String expResult = ""+n;
    String result = a.toString();
    assertEquals(expResult, result);
  }

  /**
   * Test of rand method, of class Double.
   */
  @Test
  public void testRand() {
    System.out.println("rand");
    Double instance = new Double(0.0);
    Class<Double> expResult = Double.class;
    Double result = instance.rand();
    assertEquals(expResult, result.getClass());
  }
  
}
