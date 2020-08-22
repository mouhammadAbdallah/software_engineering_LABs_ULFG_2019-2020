/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td2socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class ServerEchoTcp {

    /**
     * @param args the command line arguments
     */
    static int port = 2003;

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket server = new ServerSocket(port);//si (port,1)1 mean un seule client peut attendre
            System.out.println("Attente des clients:");
            Socket socket = server.accept();

            System.out.println("connection de " + socket.getRemoteSocketAddress());
            Scanner inSocket = new Scanner(socket.getInputStream());
            String request = inSocket.nextLine();
            System.out.println("message de client:" + request);

            PrintStream outSocket = new PrintStream(socket.getOutputStream());
            outSocket.println(request.toUpperCase());

        } catch (IOException ex) {
            Logger.getLogger(ServerEchoTcp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
