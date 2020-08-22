package td3TcpCalcul;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServeurCalculPara {

    public static void main(String[] args) {
        try {
            int port = 2000;
            ServerSocket server = new ServerSocket(port);//new ServerSocket(port,1) max 2 clients
            System.out.println(InetAddress.getLocalHost());

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client:" + socket.getRemoteSocketAddress());

                (new ServeurChild(socket)).start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
