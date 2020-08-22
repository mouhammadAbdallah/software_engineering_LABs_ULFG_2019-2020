
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td4chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salah
 */
public class Clientv2 {

    /**
     * @param args the command line arguments
     */
    static int port = 2000;
    static String host = "127.0.0.1";

    public static void main(String[] args) throws InterruptedException {
        try {
            // TODO code application logic here
            Socket socket = new Socket(host, port);

            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            (new ReaderSocket(in)).start();
            (new WriterSocket(out)).start();
        } catch (IOException ex) {
            Logger.getLogger(Clientv2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
