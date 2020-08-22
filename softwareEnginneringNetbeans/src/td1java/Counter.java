/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td1java;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class Counter extends Thread {

    /**
     * @param args the command line arguments
     */
    int startNb, endNb;

    public Counter(int s, int e) {
        startNb = s;
        endNb = e;
    }

    public void run() {
        for (int i = startNb; i < endNb; i++) {
            try {
                sleep(10);//ms
                System.out.println(i);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        //3 types to create process: classes -timer :generally in GUI(class)
        //-runable(interface)
        //-thread class(our case)
        Thread c1 = new Counter(1, 100);
        Thread c2 = new Counter(101, 200);
        //c1.setPriority(MIN_PRIORITY);//clear when number of thread more than the number of cpu
        //c2.setPriority(MAX_PRIORITY);
        c1.start();
        c2.start();
        //c1.stop();//to stop a thread
        //c1.suspend();c1.resume();
    }
}


