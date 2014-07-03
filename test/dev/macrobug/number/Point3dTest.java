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
public class Point3dTest {
  private Random r;
  
  public Point3dTest() {
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
   * Test of setZ method, of class Point3d.
   */
  @Test
  public void testSetZ() {
    System.out.println("setZ");
    Point3d instance = new Point3d(new Double(0),new Double(0),new Double(0));
    for(int i=0;i<100;i++){
      Double z = new Double(r.nextDouble());
      instance.setZ(z);
      assertEquals(z.getReal(), instance.getZ().getReal(),0);
    }
  }

  /**
   * Test of getZ method, of class Point3d.
   */
  @Test
  public void testGetZ() {
    System.out.println("getZ");
    for(int i=0;i<100;i++){
      Double z = new Double(r.nextDouble());
      Point3d instance = new Point3d(new Double(0),new Double(0),z);
      assertEquals(z.getReal(), instance.getZ().getReal(),0);
    }
  }

  /**
   * Test of translate method, of class Point3d.
   */
  @Test
  public void testTranslate_Point3d() {
    System.out.println("translate");
    Point3d[] array = new Point3d[]{
      new Point3d(new Double(0),new Double(0),new Double(-3)),
      new Point3d(new Double(1),new Double(1),new Double(-2)),
      new Point3d(new Double(-1),new Double(1),new Double(-1)),
      new Point3d(new Double(1),new Double(-2),new Double(0)),
      new Point3d(new Double(5), new Double(0),new Double(1)),
      new Point3d(new Double(0), new Double(6),new Double(2))
    };
    Point3d[] results = new Point3d[]{
      new Point3d(new Double(1),new Double(1),new Double(-5)),
      new Point3d(new Double(0),new Double(2),new Double(-3)),
      new Point3d(new Double(0),new Double(-1),new Double(-1)),
      new Point3d(new Double(6),new Double(-2),new Double(1)),
      new Point3d(new Double(5),new Double(6),new Double(3))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point3d a = array[i];
      Point3d b = array[i + 1];
      Point3d expResult = results[i];
      a.translate(b);
      assertEquals(expResult.getX().getReal(), a.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), a.getY().getReal(), 0.0);
      assertEquals(expResult.getZ().getReal(), a.getZ().getReal(), 0.0);
    }
  }
  @Test
  public void testTranslate_Point() {
    System.out.println("translate");
    Point3d[] array = new Point3d[]{
      new Point3d(new Double(0),new Double(0),new Double(-3)),
      new Point3d(new Double(1),new Double(1),new Double(-2)),
      new Point3d(new Double(-1),new Double(1),new Double(-1)),
      new Point3d(new Double(1),new Double(-2),new Double(0)),
      new Point3d(new Double(5), new Double(0),new Double(1)),
      new Point3d(new Double(0), new Double(6),new Double(2))
    };
    Point2d[] array2 = new Point2d[]{
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6)),
      new Point2d(new Double(0),new Double(0))
    };
    Point3d[] results = new Point3d[]{
      new Point3d(new Double(1),new Double(1),new Double(-3)),
      new Point3d(new Double(0),new Double(2),new Double(-2)),
      new Point3d(new Double(0),new Double(-1),new Double(-1)),
      new Point3d(new Double(6),new Double(-2),new Double(0)),
      new Point3d(new Double(5),new Double(6),new Double(1)),
      new Point3d(new Double(0),new Double(6),new Double(2))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point3d a = array[i];
      Point2d b = array2[i];
      Point3d expResult = results[i];
      a.translate(b);
      assertEquals(expResult.getX().getReal(), a.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), a.getY().getReal(), 0.0);
      assertEquals(expResult.getZ().getReal(), a.getZ().getReal(), 0.0);
    }
  }
  /**
   * Test of add method, of class Point3d.
   */
  @Test
  public void testAdd_Point() {
    System.out.println("add");
    Point3d[] array = new Point3d[]{
      new Point3d(new Double(0),new Double(0),new Double(-3)),
      new Point3d(new Double(1),new Double(1),new Double(-2)),
      new Point3d(new Double(-1),new Double(1),new Double(-1)),
      new Point3d(new Double(1),new Double(-2),new Double(0)),
      new Point3d(new Double(5), new Double(0),new Double(1)),
      new Point3d(new Double(0), new Double(6),new Double(2))
    };
    Point2d[] array2 = new Point2d[]{
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6)),
      new Point2d(new Double(0),new Double(0))
    };
    Point3d[] results = new Point3d[]{
      new Point3d(new Double(1),new Double(1),new Double(-3)),
      new Point3d(new Double(0),new Double(2),new Double(-2)),
      new Point3d(new Double(0),new Double(-1),new Double(-1)),
      new Point3d(new Double(6),new Double(-2),new Double(0)),
      new Point3d(new Double(5),new Double(6),new Double(1)),
      new Point3d(new Double(0),new Double(6),new Double(2))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point3d a = array[i];
      Point2d b = array2[i];
      Point3d expResult = results[i];
      Point3d result = a.add(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
      assertEquals(expResult.getZ().getReal(), result.getZ().getReal(), 0.0);
    }
  }

  /**
   * Test of add method, of class Point3d.
   */
  @Test
  public void testAdd_Point3d() {
    System.out.println("add");
    Point3d[] array = new Point3d[]{
      new Point3d(new Double(0),new Double(0),new Double(-3)),
      new Point3d(new Double(1),new Double(1),new Double(-2)),
      new Point3d(new Double(-1),new Double(1),new Double(-1)),
      new Point3d(new Double(1),new Double(-2),new Double(0)),
      new Point3d(new Double(5), new Double(0),new Double(1)),
      new Point3d(new Double(0), new Double(6),new Double(2))
    };
    Point3d[] results = new Point3d[]{
      new Point3d(new Double(1),new Double(1),new Double(-5)),
      new Point3d(new Double(0),new Double(2),new Double(-3)),
      new Point3d(new Double(0),new Double(-1),new Double(-1)),
      new Point3d(new Double(6),new Double(-2),new Double(1)),
      new Point3d(new Double(5),new Double(6),new Double(3))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point3d a = array[i];
      Point3d b = array[i + 1];
      Point3d expResult = results[i];
      Point3d result = a.add(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
      assertEquals(expResult.getZ().getReal(), result.getZ().getReal(), 0.0);
    }
  }

  /**
   * Test of distanceSq method, of class Point3d.
   */
  @Test
  public void testDistanceSq_Point() {
    System.out.println("distanceSq");
    Point position = null;
    Point3d instance = new Point3d();
    Number expResult = null;
    Number result = instance.distanceSq(position);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of distanceSq method, of class Point3d.
   */
  @Test
  public void testDistanceSq_Point3d() {
    System.out.println("distanceSq");
    Point3d position = null;
    Point3d instance = new Point3d();
    Number expResult = null;
    Number result = instance.distanceSq(position);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of depolar method, of class Point3d.
   */
  @Test
  public void testDepolar() {
    System.out.println("depolar");
    Point3d instance = new Point3d();
    Point3d expResult = null;
    Point3d result = instance.depolar();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of sub method, of class Point3d.
   */
  @Test
  public void testSub_Point() {
    System.out.println("sub");
    Point3d[] array = new Point3d[]{
      new Point3d(new Double(0),new Double(0),new Double(-3)),
      new Point3d(new Double(1),new Double(1),new Double(-2)),
      new Point3d(new Double(-1),new Double(1),new Double(-1)),
      new Point3d(new Double(1),new Double(-2),new Double(0)),
      new Point3d(new Double(5), new Double(0),new Double(1)),
      new Point3d(new Double(0), new Double(6),new Double(2))
    };
    Point2d[] array2 = new Point2d[]{
      new Point2d(new Double(1),new Double(1)),
      new Point2d(new Double(-1),new Double(1)),
      new Point2d(new Double(1),new Double(-2)),
      new Point2d(new Double(5), new Double(0)),
      new Point2d(new Double(0), new Double(6)),
      new Point2d(new Double(0),new Double(0))
    };
    Point3d[] results = new Point3d[]{
      new Point3d(new Double(-1),new Double(-1),new Double(-1)),
      new Point3d(new Double(2),new Double(0),new Double(-1)),
      new Point3d(new Double(-2),new Double(3),new Double(-1)),
      new Point3d(new Double(-4),new Double(-2),new Double(-1)),
      new Point3d(new Double(5),new Double(-6),new Double(-1))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point3d a = array[i];
      Point2d b = array2[i];
      Point3d expResult = results[i];
      Point3d result = a.sub(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
      assertEquals(expResult.getZ().getReal(), result.getZ().getReal(), 0.0);
    }
  }

  /**
   * Test of sub method, of class Point3d.
   */
  @Test
  public void testSub_Point3d() {
    System.out.println("sub");
    Point3d[] array = new Point3d[]{
      new Point3d(new Double(0),new Double(0),new Double(-3)),
      new Point3d(new Double(1),new Double(1),new Double(-2)),
      new Point3d(new Double(-1),new Double(1),new Double(-1)),
      new Point3d(new Double(1),new Double(-2),new Double(0)),
      new Point3d(new Double(5), new Double(0),new Double(1)),
      new Point3d(new Double(0), new Double(6),new Double(2))
    };
    Point3d[] results = new Point3d[]{
      new Point3d(new Double(-1),new Double(-1),new Double(-1)),
      new Point3d(new Double(2),new Double(0),new Double(-1)),
      new Point3d(new Double(-2),new Double(3),new Double(-1)),
      new Point3d(new Double(-4),new Double(-2),new Double(-1)),
      new Point3d(new Double(5),new Double(-6),new Double(-1))
    };
    for (int i = 0; i < array.length - 1; i++) {
      Point3d a = array[i];
      Point3d b = array[i + 1];
      Point3d expResult = results[i];
      Point3d result = a.sub(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
      assertEquals(expResult.getZ().getReal(), result.getZ().getReal(), 0.0);
    }
  }

  /**
   * Test of diffPolar method, of class Point3d.
   */
  @Test
  public void testDiffPolar_Point() {
    System.out.println("diffPolar");
    Point p = null;
    Point3d instance = new Point3d();
    Point3d expResult = null;
    Point3d result = instance.diffPolar(p);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of diffPolar method, of class Point3d.
   */
  @Test
  public void testDiffPolar_Point3d() {
    System.out.println("diffPolar");
    Point3d p = null;
    Point3d instance = new Point3d();
    Point3d expResult = null;
    Point3d result = instance.diffPolar(p);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of times method, of class Point3d.
   */
  @Test
  public void testTimes() {
    System.out.println("times");
    double b=8;
    Point3d[] array = new Point3d[]{
      new Point3d(new Double(0),new Double(0),new Double(-3)),
      new Point3d(new Double(1),new Double(1),new Double(-2)),
      new Point3d(new Double(-1),new Double(1),new Double(-1)),
      new Point3d(new Double(1),new Double(-2),new Double(0)),
      new Point3d(new Double(5), new Double(0),new Double(1)),
      new Point3d(new Double(0), new Double(6),new Double(2))
    };
    Point3d[] results = new Point3d[]{
      new Point3d(new Double(0),new Double(0),new Double(-24)),
      new Point3d(new Double(8),new Double(8),new Double(-16)),
      new Point3d(new Double(-8),new Double(8),new Double(-8)),
      new Point3d(new Double(8),new Double(-16),new Double(0)),
      new Point3d(new Double(40),new Double(0),new Double(8)),
      new Point3d(new Double(0),new Double(48),new Double(16))
    };
    for (int i = 0; i < array.length; i++) {
      Point3d a = array[i];
      Point3d expResult = results[i];
      Point3d result = a.times(b);
      assertEquals(expResult.getX().getReal(), result.getX().getReal(), 0.0);
      assertEquals(expResult.getY().getReal(), result.getY().getReal(), 0.0);
      assertEquals(expResult.getZ().getReal(), result.getZ().getReal(), 0.0);
    }
  }
}
