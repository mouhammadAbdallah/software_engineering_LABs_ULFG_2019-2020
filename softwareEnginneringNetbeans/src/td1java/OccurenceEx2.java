/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td1java;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class OccurenceEx2 extends Thread {

    static int[] arr;
    static int lookFor;
    boolean firstSubTable;
    int counter;
    public OccurenceEx2(boolean first) {
        counter = 0;
        firstSubTable = first;
    }

    public void run() {
        
        if (firstSubTable) {
            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] == lookFor) {
                    counter++;
                }
            }
        } else {
            for (int i = arr.length / 2; i < arr.length; i++) {

                if (arr[i] == lookFor) {
                    counter++;
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        int[]table = {2,3,4,5,4,6,20,4};
        arr=table;
        lookFor=4;
        
        OccurenceEx2 c1=new OccurenceEx2(true);
        OccurenceEx2 c2=new OccurenceEx2(false);

        c1.start();
        c2.start();
        
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(OccurenceEx2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.print("NO = ");System.out.println(c1.counter+c2.counter);
        
    }

}
