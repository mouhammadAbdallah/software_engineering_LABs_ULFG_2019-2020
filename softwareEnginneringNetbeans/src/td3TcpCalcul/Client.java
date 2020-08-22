package td3TcpCalcul;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) {
        try {
            int port = 3000;
            String host;
            Scanner key = new Scanner(System.in);
            System.out.println("host?");
            host = key.nextLine();

            Socket socket = new Socket(host, port);
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());

            while (true) {
                System.out.println("FNB oper LNb Or end");
                String data = key.nextLine();
                out.println(data);//end or double
                if (data.equals("end")) {
                    break;
                }
                out.println(key.nextLine());//operation
                out.println(key.nextLine());//double

                String reponse = in.nextLine();
                System.out.println("reponse=" + reponse);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
