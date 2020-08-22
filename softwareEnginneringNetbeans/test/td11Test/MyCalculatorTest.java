/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td11Test;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Moham
 */
public class MyCalculatorTest {

    static int N;

    public MyCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        N = 1000;
        System.out.println("set up class");
    }

    @AfterClass
    public static void tearDownClass() {
        N = 0;
        System.out.println("tear down class");
    }

    @Before
    public void setUp() {
        System.out.println("set up");
    }

    @After
    public void tearDown() {
        System.out.println("tear down");
    }

    /**
     * Test of Sum method, of class MyCalculator.
     */
    @Test
    public void testSum() {
        System.out.println("Sum");
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            double a = 100 * r.nextDouble();
            double b = 100 * r.nextDouble();
            double expResult = a + b;
            double result = MyCalculator.Sum(a, b);
            assertEquals(expResult, result, 0.00001);
        }

    }

    /**
     * Test of Divide method, of class MyCalculator.
     */
    @Test
    public void testDivide() {
        System.out.println("Divide");
        double a = 100;
        double b = 0;
        double expResult = -1;
        double result = MyCalculator.Divide(a, b);
        assertEquals(expResult, result, 0.00001);
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            a = 100 * r.nextDouble();
            b = 100 * r.nextDouble();
            expResult = a / b;
            result = MyCalculator.Divide(a, b);
            assertEquals(expResult, result, 0.00001);
        }
    }

}
