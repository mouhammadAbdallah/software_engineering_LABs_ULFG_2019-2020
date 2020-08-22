
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td4chat;

import java.util.Scanner;

/**
 *
 * @author Salah
 */
public class ReaderSocket extends Thread {

    Scanner inSocket;

    public ReaderSocket(Scanner inSocket) {
        this.inSocket = inSocket;
    }

    public void run() {
        while (true) {
            String datafromClient = inSocket.nextLine();
            System.out.println(">>" + datafromClient);
        }
    }
}
