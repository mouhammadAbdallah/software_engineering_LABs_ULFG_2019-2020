
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
public class Clientv1 {

    /**
     * @param args the command line arguments
     */
    static int port = 2000;
    static String host = "127.0.0.1";

    public static void main(String[] args) throws InterruptedException {
        try {
            // TODO code application logic here
            Socket socket = new Socket(host, port);
            Scanner key = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            while (true) {
                System.out.print("C:");
                String data = key.nextLine();
                out.println(data);
                if (data.equals("end")) {
                    break;
                }
                String datafromServer = in.nextLine();
                System.out.println("S:" + datafromServer);
            }
            Thread.sleep(2000);
        } catch (IOException ex) {
            Logger.getLogger(Clientv1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
