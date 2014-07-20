/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.macrobug.number;

import java.util.Random;
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
  private Random r;
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
    r=new Random(System.currentTimeMillis());
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
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      Complex.ZERO,
      new Complex(5),
      new Complex(5, 8)
    };
    double[] results = new double[]{
      1,
      0,
      0,
      0,
      8
    };
    for (int i = 0; i < array.length; i++) {
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
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      Complex.ZERO,
      new Complex(5),
      new Complex(3, 4)
    };
    double[] results = new double[]{
      1,
      1,
      0,
      5,
      5
    };
    for (int i = 0; i < array.length; i++) {
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
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    double[] results = new double[]{
      Math.PI / 2,
      0,
      0,
      0.9272952180016122,
      0.6435011087932844
    };
    for (int i = 0; i < array.length; i++) {
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
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    Double b = new Double(8);
    Complex[] results = new Complex[]{
      new Complex(8.0, 1.0),
      new Complex(9.0),
      new Complex(13.0, 0.0),
      new Complex(11.0, 4.0),
      new Complex(12.0, 3.0)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex expResult = results[i];
      Complex result = a.add(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of add method, of class Complex.
   */
  @Test
  public void testAdd_Complex() {
    System.out.println("add");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    Complex[] results = new Complex[]{
      new Complex(1.0, 1.0),
      new Complex(6.0),
      new Complex(8.0, 4.0),
      new Complex(7.0, 7.0)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex b = array[i + 1];
      Complex expResult = results[i];
      Complex result = a.add(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of sub method, of class Complex.
   */
  @Test
  public void testSub_Number() {
    System.out.println("sub");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    Double b = new Double(8);
    Complex[] results = new Complex[]{
      new Complex(-8.0, 1.0),
      new Complex(-7.0),
      new Complex(-3.0, 0.0),
      new Complex(-5, 4.0),
      new Complex(-4, 3.0)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex expResult = results[i];
      Complex result = a.sub(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of sub method, of class Complex.
   */
  @Test
  public void testSub_Complex() {
    System.out.println("sub");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    Complex[] results = new Complex[]{
      new Complex(-1.0, 1.0),
      new Complex(-4.0),
      new Complex(2, -4.0),
      new Complex(-1, 1)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex b = array[i + 1];
      Complex expResult = results[i];
      Complex result = a.sub(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of times method, of class Complex.
   */
  @Test
  public void testTimes_Number() {
    System.out.println("times");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    Double b = new Double(8);
    Complex[] results = new Complex[]{
      new Complex(0,8),
      new Complex(8,0),
      new Complex(40,0),
      new Complex(24, 32),
      new Complex(32, 24)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex expResult = results[i];
      Complex result = a.times(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of times method, of class Complex.
   */
  @Test
  public void testTimes_Complex() {
    System.out.println("times");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    Complex[] results = new Complex[]{
      Complex.I,
      new Complex(5),
      new Complex(15, 20.0),
      new Complex(0, 25)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex b = array[i + 1];
      Complex expResult = results[i];
      Complex result = a.times(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of div method, of class Complex.
   */
  @Test
  public void testDiv_Number() {
    System.out.println("div");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    Double b = new Double(8);
    Complex[] results = new Complex[]{
      new Complex(0, 0.125),
      new Complex(0.125,0),
      new Complex(0.625, 0.0),
      new Complex(0.375, 0.5),
      new Complex(0.5, 0.375)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex expResult = results[i];
      Complex result = a.div(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of div method, of class Complex.
   */
  @Test
  public void testDiv_Complex() {
    System.out.println("div");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    Complex[] results = new Complex[]{
      Complex.I,
      new Complex(1.0/5,0),
      new Complex(0.6, -0.8),
      new Complex(0.96,0.28)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex b = array[i + 1];
      Complex expResult = results[i];
      Complex result = a.div(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of pow method, of class Complex.
   */
  @Test
  public void testPow() {
    System.out.println("pow");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    double b = 8;
    Complex[] results = new Complex[]{
      Complex.ONE,
      Complex.ONE,
      new Complex(390625,0),
      new Complex(164833, 354144),
      new Complex(164833, -354144)
    };
    double delta=Math.pow(10, 10);
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex expResult = results[i];
      Complex result = a.pow(b);
      assertEquals(expResult.getReal(), result.getReal(), delta);
      assertEquals(expResult.getImage(), result.getImage(), delta);
    }
  }

  /**
   * Test of atan method, of class Complex.
   */
  @Test
  public void testAtan() {
    System.out.println("atan");
    Complex[] array = new Complex[]{
      new Complex(0, 2),
      Complex.ONE,
      new Complex(5),
      new Complex(3, -4)
    };
    Complex[] results = new Complex[]{
      new Complex(1.570796327, 0.549306144),
      new Complex(0.785398163, 0),
      new Complex(0.698970004, 0),
      new Complex(0.698970004, 0.402719196)
    };
    double delta=Math.pow(10, 9);
    for (int i = 0; i < array.length; i++) {
      Complex instance = array[i];
      Complex expResult = results[i];
      Complex result = instance.atan();
      assertEquals(expResult.getReal(), result.getReal(), delta);
      assertEquals(expResult.getImage(), result.getImage(), delta);
    }
  }

  /**
   * Test of log method, of class Complex.
   */
  @Test
  public void testLog() {
    System.out.println("log");
    Complex[] array = new Complex[]{
      Complex.I,
      new Complex(0, 2),
      Complex.ONE,
      new Complex(5),
      new Complex(3, -4)
    };
    Complex[] results = new Complex[]{
      new Complex(0,1.5707963267948966),
      new Complex(0.6931471805599453, 1.5707963267948966),
      new Complex(0, 0),
      new Complex(1.6094379124341003, 0),
      new Complex(1.6094379124341003, -0.9272952180016122)
    };
    for (int i = 0; i < array.length; i++) {
      Complex instance = array[i];
      Complex expResult = results[i];
      Complex result = instance.log();
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of times method, of class Complex.
   */
  @Test
  public void testTimes_double() {
    System.out.println("times");
    Complex[] array = new Complex[]{
      Complex.I,
      Complex.ONE,
      new Complex(5),
      new Complex(3, 4),
      new Complex(4, 3)
    };
    double b = 8;
    Complex[] results = new Complex[]{
      new Complex(0,8),
      new Complex(8,0),
      new Complex(40,0),
      new Complex(24, 32),
      new Complex(32, 24)
    };
    for (int i = 0; i < array.length - 1; i++) {
      Complex a = array[i];
      Complex expResult = results[i];
      Complex result = a.times(b);
      assertEquals(expResult.getReal(), result.getReal(), 0.0);
      assertEquals(expResult.getImage(), result.getImage(), 0.0);
    }
  }

  /**
   * Test of sin method, of class Complex.
   */
  @Test
  public void testSin() {
    System.out.println("sin");
    Complex[] array = new Complex[]{
      Complex.I,
      new Complex(0, 2),
      Complex.ONE,
      new Complex(5),
      new Complex(3, -4)
    };
    Complex[] results = new Complex[]{
      new Complex(0,1.1752011936438014),
      new Complex(0,3.626860407847019),
      new Complex(0.8414709848078965, 0),
      new Complex(-0.9589242746631385, 0),
      new Complex(3.853738037919377, 27.016813258003932)
    };
    double delta=Math.pow(10, 10);
    for (int i = 0; i < array.length; i++) {
      Complex instance = array[i];
      Complex expResult = results[i];
      Complex result = instance.sin();
      assertEquals(expResult.getReal(), result.getReal(), delta);
      assertEquals(expResult.getImage(), result.getImage(), delta);
    }
  }

  /**
   * Test of cos method, of class Complex.
   */
  @Test
  public void testCos() {
    System.out.println("cos");
    Complex[] array = new Complex[]{
      Complex.I,
      new Complex(0, 2),
      Complex.ONE,
      new Complex(5),
      new Complex(3, -4)
    };
    Complex[] results = new Complex[]{
      new Complex(1.5707963267948966, 0),
      new Complex(3.7621956910836314, 0),
      new Complex(0.5403023058681398, 0),
      new Complex(0.28366218546322625, 0),
      new Complex(-27.034945603074224, 3.851153334811777)
    };
    double delta=Math.pow(10, 10);
    for (int i = 0; i < array.length; i++) {
      Complex instance = array[i];
      Complex expResult = results[i];
      Complex result = instance.cos();
      assertEquals(expResult.getReal(), result.getReal(), delta);
      assertEquals(expResult.getImage(), result.getImage(), delta);
    }
  }

  /**
   * Test of toString method, of class Complex.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    double i=r.nextDouble();
    double j=r.nextDouble();
    Complex a=new Complex(i,j);
    String expResult = "("+i+"+"+j+"i)";
    String result = a.toString();
    assertEquals(expResult, result);
  }

  /**
   * Test of rand method, of class Complex.
   */
  @Test
  public void testRand() {
    System.out.println("rand");
    Complex instance = new Complex(0.0,1.0);
    Class<Complex> expResult = Complex.class;
    Complex result = instance.rand();
    assertEquals(expResult, result.getClass());
  }

  /**
   * Test of rand method, of class Complex.
   */
  @Test
  public void testRand_0args() {
    System.out.println("rand");
    Complex expResult = null;
    Complex result = Complex.rand();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of rand method, of class Complex.
   */
  @Test
  public void testRand_double() {
    System.out.println("rand");
    double max = 0.0;
    Complex expResult = null;
    Complex result = Complex.rand(max);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of rand method, of class Complex.
   */
  @Test
  public void testRand_double_double() {
    System.out.println("rand");
    double min = 0.0;
    double max = 0.0;
    Complex expResult = null;
    Complex result = Complex.rand(min, max);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of parse method, of class Complex.
   */
  @Test
  public void testParse() {
    System.out.println("parse");
    String s = "0.123i-32.5435";
    Complex expResult = new Complex(-32.5435,0.123);
    Complex result = Complex.parse(s);
    double delta=Math.pow(10, 10);
    assertEquals(expResult.getReal(), result.getReal(), delta);
    assertEquals(expResult.getImage(), result.getImage(), delta);
  }

}
