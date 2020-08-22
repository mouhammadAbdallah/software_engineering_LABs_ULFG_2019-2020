/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fact;

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
public class FactTest {
    
    public FactTest() {
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
     * Test of factoriel method, of class Fact.
     */
     public static int fact(int n) {
      if (n <= 1)
         return 1;
      else
         return n * fact(n - 1);
   }
    @Test
    public void testFactoriel() {
        System.out.println("factoriel");
        Random r=new Random();
        
        for(int i=0;i<1000;i++){
            int n=r.nextInt(10000);//car type int
            System.out.println(n);
            int result = Fact.factoriel(n);
            int expResult =fact(n);
            assertEquals(expResult, result);
        }
        
        assertEquals(1, Fact.factoriel(0));
        
        assertEquals(1, Fact.factoriel(1));
        
        assertEquals(2, Fact.factoriel(2));
        
        assertEquals(-1, Fact.factoriel(-100));// -1 means not acceptable
        
    }
    
}
