
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
public class Serverv1 {

    static int port = 2000;

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket server = new ServerSocket(port);
            System.out.println("Waiting client");
            Socket socket = server.accept();
            Scanner key = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            while (true) {
                String datafromClient = in.nextLine();
                System.out.println("C:" + datafromClient);
                if (datafromClient.equals("end")) {
                    break;
                }
                System.out.print("S:");
                String data = key.nextLine();
                out.println(data);

                //if(equals(.....
            }

        } catch (IOException ex) {
            Logger.getLogger(Serverv1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
