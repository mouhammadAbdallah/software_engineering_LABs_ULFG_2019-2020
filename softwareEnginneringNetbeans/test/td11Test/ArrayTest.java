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
public class ArrayTest {

    static double[] testArray;
    static double[]nullArray;
    static double avg;
    static double[] initialArray;
    static int N;

    public ArrayTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        N = 100;
        avg = 0;

        testArray = new double[N];
        initialArray = new double[N];
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            testArray[i] = r.nextDouble() * 100;
            initialArray[i] = testArray[i];
            avg += testArray[i];
        }
        avg = avg / N;

    }

    @AfterClass
    public static void tearDownClass() {
        for (int i = 0; i < N; i++) {
            assertEquals(initialArray[i], testArray[i], 0.001);
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of GetAvarage method, of class Array.
     */
    @Test
    public void testGetAvarage() {
        System.out.println("GetAvarage");

        double result = Array.GetAvarage(testArray);
        assertEquals(result, avg, 0.00001);
        
         result = Array.GetAvarage(nullArray);
        assertEquals(result, 0, 0.00001);

    }

    /**
     * Test of Sort method, of class Array.
     */
    @Test
    public void testSort() {
        System.out.println("Sort");
        double[] result = Array.Sort(testArray);
        for (int i = 0; i < N - 1; i++) {
            assertTrue(result[i] <= result[i + 1]);
        }
        result = Array.Sort(nullArray);
        if(result==null)assertTrue(true);
        else assertTrue(false);

    }

    private void assertArrayEquals(Object object, double[] result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
