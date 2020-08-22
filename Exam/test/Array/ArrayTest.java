/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import java.util.Arrays;
import java.util.Collections;
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

    static int[] testArray;
    static int[] nullArray;
    static int[] initialArray;
    static int N;

    public ArrayTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        N = 100;
        nullArray = null;
        testArray = new int[N];
        initialArray = new int[N];
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            testArray[i] = r.nextInt();
            initialArray[i] = testArray[i];
        }
    }

    @AfterClass
    public static void tearDownClass() {//data not changing
        for (int i = 0; i < N; i++) {
            assertEquals(initialArray[i], testArray[i], 0.00001);
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of indexMax method, of class Array.
     */
    @Test
    public void testIndexMax() {

        System.out.println("indexMax");
        int result = Array.indexMax(testArray);
        int max = testArray[result];
        for (int i = 0; i < testArray.length; i++) {
            assertTrue(max >= testArray[i]);
        }
        // if null;
        result = Array.indexMax(nullArray);
        int expected = -1;
        assertEquals(expected, result);

        //if all table element all equals return the first index =0;
        int[] table = {1, 1, 1, 1, 1, 1, 1};
        result = Array.indexMax(table);
        assertEquals(0, result);

    }

    /**
     * Test of insertElement method, of class Array.
     */
    @Test
    public void testInsertElement() {
        System.out.println("insertElement");
        Random r = new Random();
        int element = r.nextInt();

        int[] testarr = new int[N];
        System.arraycopy(testArray, 0, testarr, 0, N);
        //if sorted array
        Arrays.sort(testarr);
        int[] result = Array.insertElement(testarr, element);
        int i = 0;
        while (i + 1 < result.length) {
            if (result[i] > result[i + 1]) {
                break;
            }
            i++;
        }
        assertTrue(i + 1 == result.length);

        //if null;
        result = Array.insertElement(nullArray, element);
        assertEquals(null, result);

        //if not a sorted array it should return a sorted array versin with the  inserted  the element
        result = Array.insertElement(testArray, element);
        i = 0;
        while (i + 1 < result.length) {
            if (result[i] > result[i + 1]) {
                break;
            }
            i++;
        }
        assertTrue(i + 1 == result.length);
        // if all element in the table are equal the inserted element 

        int[] table = {1, 1, 1, 1, 1, 1, 1};
        result = Array.insertElement(table, 1);
        i = 0;
        while (i + 1 < result.length) {
            if (result[i] > result[i + 1]) {
                break;
            }
            i++;
        }
        assertTrue(i + 1 == result.length);
        
        //length==length+1
        assertEquals(table.length+1, result.length);
        
    }

}
