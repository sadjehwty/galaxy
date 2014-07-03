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
public class Vector2dTest {
  
  public Vector2dTest() {
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
   * Test of getOrigin method, of class Vector2d.
   */
  @Test
  public void testGetOrigin() {
    System.out.println("getOrigin");
    Point2d expResult=new Point2d(new Double(4),new Double(5));
    Point2d notResult=new Point2d(new Double(6),new Double(-5));
    Vector2d instance = new Vector2d(expResult,notResult);
    Point result = instance.getOrigin();
    assertEquals(expResult, result);
    assertFalse(notResult.equals(result));
  }

  /**
   * Test of getValue method, of class Vector2d.
   */
  @Test
  public void testGetValue() {
    System.out.println("getValue");
    Point2d expResult=new Point2d(new Double(4),new Double(5));
    Point2d notResult=new Point2d(new Double(6),new Double(-5));
    Vector2d instance = new Vector2d(notResult,expResult);
    Point result = instance.getValue();
    assertEquals(expResult, result);
    assertFalse(notResult.equals(result));
  }

  /**
   * Test of add method, of class Vector2d.
   */
  @Test
  public void testAdd() {
    System.out.println("add");
    Point2d A=new Point2d(new Double(4),new Double(5));
    Point2d o=new Point2d(new Double(6),new Double(-5));
    Vector2d instance = new Vector2d(A,o);
    Point2d a=new Point2d(new Double(7),new Double(-3));
    o=new Point2d(new Double(2),new Double(-6));
    Vector2d v = new Vector2d(a,o);
    Vector2d expResult = new Vector2d(A,new Point2d(new Double(1),new Double(-8)));
    Vector2d result = instance.add(v);
    assertEquals(expResult.getOrigin().getX().getReal(), result.getOrigin().getX().getReal(),0);
    assertEquals(expResult.getValue().getX().getReal(), result.getValue().getX().getReal(),0);
    assertEquals(expResult.getOrigin().getY().getReal(), result.getOrigin().getY().getReal(),0);
    assertEquals(expResult.getValue().getY().getReal(), result.getValue().getY().getReal(),0);
  }

  /**
   * Test of translate method, of class Vector2d.
   */
  @Test
  public void testTranslate() {
    System.out.println("add!");
    Point2d A=new Point2d(new Double(4),new Double(5));
    Point2d o=new Point2d(new Double(6),new Double(-5));
    Vector2d instance = new Vector2d(A,o);
    Point2d a=new Point2d(new Double(7),new Double(-3));
    o=new Point2d(new Double(2),new Double(-6));
    Vector2d v = new Vector2d(a,o);
    Vector2d expResult = new Vector2d(A,new Point2d(new Double(1),new Double(-8)));
    Vector2d result = instance.translate(v);
    assertEquals(expResult.getOrigin().getX().getReal(), result.getOrigin().getX().getReal(),0);
    assertEquals(expResult.getValue().getX().getReal(), result.getValue().getX().getReal(),0);
    assertEquals(expResult.getOrigin().getY().getReal(), result.getOrigin().getY().getReal(),0);
    assertEquals(expResult.getValue().getY().getReal(), result.getValue().getY().getReal(),0);
    assertEquals(result, instance);
  }
  
}
