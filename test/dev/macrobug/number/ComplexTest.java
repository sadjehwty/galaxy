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
public class ComplexTest {
  
  public ComplexTest() {
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
   * Test of getImage method, of class Complex.
   */
  @Test
  public void testGetImage() {
    System.out.println("getImage");
    Complex[] array=new Complex[]{
      Complex.I,
      Complex.ONE,
      Complex.ZERO,
      new Complex(5),
      new Complex(5,8)
    };
    double[] results=new double[]{
      1,
      0,
      0,
      0,
      8
    };
    for(int i=0;i<array.length;i++){
      Complex instance = array[i];
      double expResult = results[i];
      double result = instance.getImage();
      assertEquals(expResult, result, 0.0);
    }
  }

  /**
   * Test of abs method, of class Complex.
   */
  @Test
  public void testAbs() {
    System.out.println("abs");
    Complex[] array=new Complex[]{
      Complex.I,
      Complex.ONE,
      Complex.ZERO,
      new Complex(5),
      new Complex(3,4)
    };
    double[] results=new double[]{
      1,
      1,
      0,
      5,
      5
    };
    for(int i=0;i<array.length;i++){
      Complex instance = array[i];
      double expResult = results[i];
      double result = instance.abs();
      assertEquals(expResult, result, 0.0);
    }
  }

  /**
   * Test of arg method, of class Complex.
   */
  @Test
  public void testArg() {
    System.out.println("arg");
    Complex[] array=new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3,4),
      new Complex(4,3)
    };
    double[] results=new double[]{
      Math.PI/2,
      0,
      0,
      0.9272952180016122,
      0.6435011087932844
    };
    for(int i=0;i<array.length;i++){
      Complex instance = array[i];
      double expResult = results[i];
      double result = instance.arg();
      assertEquals(expResult, result, 0.0);
    }
  }

  /**
   * Test of add method, of class Complex.
   */
  @Test
  public void testAdd_Number() {
    System.out.println("add");
    Complex[] array=new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3,4),
      new Complex(4,3)
    };
    Double b=new Double(8);
    Complex[] results=new Complex[]{
      new Complex(8.0,1.0),
      new Complex(9.0),
      new Complex(13.0,0.0),
      new Complex(11.0,4.0),
      new Complex(12.0,3.0)
    };
    for(int i=0;i<array.length-1;i++){
      Complex a = array[i];
      Complex expResult = results[i];
      Complex result = a.add(b);
      assertEquals(expResult.getReal(), result.getReal(),0.0);
      assertEquals(expResult.getImage(), result.getImage(),0.0);
    }
  }

  /**
   * Test of add method, of class Complex.
   */
  @Test
  public void testAdd_Complex() {
    System.out.println("add");
    Complex[] array=new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3,4),
      new Complex(4,3)
    };
    Complex[] results=new Complex[]{
      new Complex(1.0,1.0),
      new Complex(6.0),
      new Complex(8.0,4.0),
      new Complex(7.0,7.0)
    };
    for(int i=0;i<array.length-1;i++){
      Complex a = array[i];
      Complex b = array[i+1];
      Complex expResult = results[i];
      Complex result = a.add(b);
      assertEquals(expResult.getReal(), result.getReal(),0.0);
      assertEquals(expResult.getImage(), result.getImage(),0.0);
    }
  }

  /**
   * Test of sub method, of class Complex.
   */
  @Test
  public void testSub_Number() {
    System.out.println("sub");
    Number t = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.sub(t);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of sub method, of class Complex.
   */
  @Test
  public void testSub_Complex() {
    System.out.println("sub");
    Complex t = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.sub(t);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of times method, of class Complex.
   */
  @Test
  public void testTimes_Number() {
    System.out.println("times");
    Number t = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.times(t);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of times method, of class Complex.
   */
  @Test
  public void testTimes_Complex() {
    System.out.println("times");
    Complex t = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.times(t);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of div method, of class Complex.
   */
  @Test
  public void testDiv_Number() {
    System.out.println("div");
    Number t = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.div(t);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of div method, of class Complex.
   */
  @Test
  public void testDiv_Complex() {
    System.out.println("div");
    Complex t = null;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.div(t);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of pow method, of class Complex.
   */
  @Test
  public void testPow() {
    System.out.println("pow");
    double t = 0.0;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.pow(t);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of atan method, of class Complex.
   */
  @Test
  public void testAtan() {
    System.out.println("atan");
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.atan();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of log method, of class Complex.
   */
  @Test
  public void testLog() {
    System.out.println("log");
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.log();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of times method, of class Complex.
   */
  @Test
  public void testTimes_double() {
    System.out.println("times");
    double d = 0.0;
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.times(d);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of sin method, of class Complex.
   */
  @Test
  public void testSin() {
    System.out.println("sin");
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.sin();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of cos method, of class Complex.
   */
  @Test
  public void testCos() {
    System.out.println("cos");
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.cos();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toString method, of class Complex.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Complex instance = null;
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of rand method, of class Complex.
   */
  @Test
  public void testRand() {
    System.out.println("rand");
    Complex instance = null;
    Complex expResult = null;
    Complex result = instance.rand();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
