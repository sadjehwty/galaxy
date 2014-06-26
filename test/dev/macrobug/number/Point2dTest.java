/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.macrobug.number;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sadjehwty
 */
public class Point2dTest {
  
  public Point2dTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of translate method, of class Point2d.
   */
  @Test
  public void testTranslate() {
    System.out.println("translate");
    Point2d[] array = new Point2d[]{
      new Point2d(new Double(0),new Double(0)),
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6))
    };
    Point2d[] results = new Point2d[]{
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(0),new Double(2)),
      new Point2d(new Double(0),new Double(-1)),
      new Point2d(new Double(6),new Double(-2)),
      new Point2d(new Double(5),new Double(6))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point2d a = array[i];
      Point2d b = array[i + 1];
      Point2d expResult = results[i];
      a.translate(b);
      assertEquals(expResult.getX().getReal(), a.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), a.getY().getReal(), 0.0);
    }
  }

  /**
   * Test of add method, of class Point2d.
   */
  @Test
  public void testAdd() {
    System.out.println("add");
    Point2d[] array = new Point2d[]{
      new Point2d(new Double(0),new Double(0)),
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6))
    };
    Point2d[] results = new Point2d[]{
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(0),new Double(2)),
      new Point2d(new Double(0),new Double(-1)),
      new Point2d(new Double(6),new Double(-2)),
      new Point2d(new Double(5),new Double(6))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point2d a = array[i];
      Point2d b = array[i + 1];
      Point2d expResult = results[i];
      Point2d result = a.add(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
    }
  }

  /**
   * Test of sub method, of class Point2d.
   */
  @Test
  public void testSub() {
    System.out.println("sub");
    Point2d[] array = new Point2d[]{
      new Point2d(new Double(0),new Double(0)),
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6))
    };
    Point2d[] results = new Point2d[]{
      new Point2d(new Double(-1),new Double(-1)),
      new Point2d(new Double(2),new Double(0)),
      new Point2d(new Double(-2),new Double(3)),
      new Point2d(new Double(-4),new Double(-2)),
      new Point2d(new Double(5),new Double(-6))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point2d a = array[i];
      Point2d b = array[i + 1];
      Point2d expResult = results[i];
      Point2d result = a.sub(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
    }
  }

  /**
   * Test of distanceSq method, of class Point2d.
   */
  @Test
  public void testDistanceSq() {
    System.out.println("distanceSq");
    Point2d[] array = new Point2d[]{
      new Point2d(new Double(0),new Double(0)),
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6))
    };
    Double[] results = new Double[]{
      new Double(2),
      new Double(4),
      new Double(13),
      new Double(20),
      new Double(61)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point2d a = array[i];
      Point2d b = array[i + 1];
      Double expResult = results[i];
      Double result = (Double) a.distanceSq(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
    }
  }

  /**
   * Test of diffPolar method, of class Point2d.
   */
  @Test
  public void testDiffPolar() {
    System.out.println("diffPolar");
    Point2d[] array = new Point2d[]{
      new Point2d(new Double(0),new Double(0)),
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6))
    };
    Point2d[] results = new Point2d[]{
      new Point2d(new Double(Math.sqrt(2)),new Double(Math.PI/4)),
      new Point2d(new Double(2),new Double(0)),
      new Point2d(new Double(Math.sqrt(13)),new Double(-0.982793723247329)),
      new Point2d(new Double(Math.sqrt(20)),new Double(0.4636476090008061)),
      new Point2d(new Double(Math.sqrt(61)),new Double(-0.8760580505981934)),
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point2d a = array[i];
      Point2d b = array[i + 1];
      Point2d expResult = results[i];
      Point2d result = a.diffPolar(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
    }
  }

  /**
   * Test of depolar method, of class Point2d.
   */
  @Test
  public void testDepolar() {
    System.out.println("depolar");
    Point2d[] array = new Point2d[]{
      new Point2d(new Double(Math.sqrt(2)),new Double(Math.PI/4)),
      new Point2d(new Double(2),new Double(0)),
      new Point2d(new Double(Math.sqrt(13)),new Double(-0.982793723247329)),
      new Point2d(new Double(Math.sqrt(20)),new Double(0.4636476090008061)),
      new Point2d(new Double(Math.sqrt(61)),new Double(-0.8760580505981934)),
    };
    Point2d[] results = new Point2d[]{
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(2),new Double(0)),
      new Point2d(new Double(-2),new Double(3)),
      new Point2d(new Double(4),new Double(2)),
      new Point2d(new Double(-5),new Double(6))
    };
    double delta = Math.pow(10,10);
    for (int i = 0; i < array.length - 1; i++) {
      Point2d a = array[i];
      Point2d expResult = results[i];
      Point2d result = a.depolar();
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), delta);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), delta);
    }
  }

  /**
   * Test of times method, of class Point2d.
   */
  @Test
  public void testTimes() {
    System.out.println("times");
    double b=8;
    Point2d[] array = new Point2d[]{
      new Point2d(new Double(0),new Double(0)),
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6))
    };
    Point2d[] results = new Point2d[]{
      new Point2d(new Double(0),new Double(0)),
      new Point2d(new Double(8),new Double(8)),
      new Point2d(new Double(-8),new Double(8)),
      new Point2d(new Double(8),new Double(-16)),
      new Point2d(new Double(40),new Double(0)),
      new Point2d(new Double(0),new Double(48))
    };
    for (int i = 0; i < array.length; i++) {
      Point2d a = array[i];
      Point2d expResult = results[i];
      Point2d result = a.times(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
    }
  }
  
}
