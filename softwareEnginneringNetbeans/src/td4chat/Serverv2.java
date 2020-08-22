
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td4chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salah
 */
public class Serverv2 {

    static int port = 2000;

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket server = new ServerSocket(port);
            System.out.println("Waiting client");
            Socket socket = server.accept();

            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            (new ReaderSocket(in)).start();
            (new WriterSocket(out)).start();

        } catch (IOException ex) {
            Logger.getLogger(Serverv2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
