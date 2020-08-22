/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td3TcpCalcul;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class ServeurCalcul {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        try {
            int port = 3000;
            ServerSocket server = new ServerSocket(port);//
            System.out.println(InetAddress.getLocalHost());

            Socket socket = server.accept();
            System.out.println("Client:" + socket.getRemoteSocketAddress());
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            while (true) {
                String data = in.nextLine();
                if (data.equals("end")) {
                    break;
                }

                double fNb = Double.parseDouble(data);
                String oper = in.nextLine();
                double lNb = Double.parseDouble(in.nextLine());
                String reponse = "";
                switch (oper) {
                    case "+":
                        reponse += (fNb + lNb);
                        break;
                    case "/":
                        reponse += (fNb / lNb);
                        break;
                    case "*":
                        reponse += (fNb * lNb);
                        break;
                    case "-":
                        reponse += (fNb - lNb);
                        break;
                }
                out.println(reponse);
            }

            in.close();
            out.close();
            socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
