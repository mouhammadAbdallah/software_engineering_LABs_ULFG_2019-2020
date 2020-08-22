package td3TcpCalcul;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) {
        try {
            int port = 3000;
            Hashtable<String, String> my_dict = new Hashtable<String, String>();
            ServerSocket server = new ServerSocket(port);//new ServerSocket(port,1) max 2 clients
            System.out.println(InetAddress.getLocalHost());

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client:" + socket.getRemoteSocketAddress());

                (new Thread() {

                    public void run() {
                        try {
                            Scanner in = new Scanner(socket.getInputStream());
                            PrintStream out = new PrintStream(socket.getOutputStream());
                            while (true) {
                                String reponse;
                                String data = in.nextLine();
                                if (data.equals("end")) {
                                    break;
                                }
                                if (data.contains(":")) {
                                    my_dict.put(data.split(":")[0].toString().trim(), data.split(":")[1].toString().trim());
                                    reponse = "done";
                                } else {
                                    reponse =my_dict.get(data.trim());
                                }

                                out.println(reponse);
                            }

                            in.close();
                            out.close();
                            socket.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ServeurCalculParaIn.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
