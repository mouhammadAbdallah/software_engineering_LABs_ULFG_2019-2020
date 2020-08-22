/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td2socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    static int port = 2002;
    static String host = "127.0.0.1";

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            System.out.println("connecting: " + host);
            Socket socket = new Socket(host, port);
            Scanner inSocket = new Scanner(socket.getInputStream());
            String response;
            Scanner scan = new Scanner(System.in);
            PrintStream outSocket = new PrintStream(socket.getOutputStream());
            

            do {
                response = inSocket.nextLine().trim();
                System.out.println(response);
                if(response.equals("GAMEOVER") || response.equals("YOUWIN"))break;
                System.out.print("-->");
                outSocket.println(scan.nextLine().charAt(0));

            } while (!response.equals("GAMEOVER") || !response.equals("YOUWIN"));

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
