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
public class ClientEchoTcp {

    /**
     * @param args the command line arguments
     */
    static int port = 2003;

    public static void main(String[] args) {
        // TODO code application logic here
        String host = "127.0.0.1";//loop back ,si ne je suis pas connecte au reseaux
        try {
            Socket socket = new Socket(host, port);
            String request = "hello";
            PrintStream outSocket = new PrintStream(socket.getOutputStream());
            outSocket.println(request);
            Scanner inSocket = new Scanner(socket.getInputStream());
            String response = inSocket.nextLine();
            System.out.println("Response de serveur:"+response);

        } catch (IOException ex) {
            Logger.getLogger(ClientEchoTcp.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

}
