package td3TcpCalcul;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clientProducerAndConsumer {

    public static void main(String[] args) {
        try {
            int port = 3000;
            String host;
            Scanner key = new Scanner(System.in);
            System.out.print("host:");
            host = key.nextLine();

            Socket socket = new Socket(host, port);
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            System.out.println("I can work as producer(ville:30) or consumer(ville):");

            while (true) {
                String data = key.nextLine();
                out.println(data);//end or double
                if (data.equals("end")) {
                    break;
                }

                String reponse = in.nextLine();
                System.out.println("---->" + reponse);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
