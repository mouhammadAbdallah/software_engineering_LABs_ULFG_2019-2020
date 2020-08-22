
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td4chat;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Salah
 */
public class WriterSocket extends Thread {

    PrintStream out;

    public WriterSocket(PrintStream out) {
        this.out = out;
    }

    public void run() {
        Scanner key = new Scanner(System.in);
        while (true) {
            System.out.print(">>");
            String data = key.nextLine();
            out.println(data);
        }
    }

}
