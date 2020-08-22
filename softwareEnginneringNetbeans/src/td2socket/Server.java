package td2socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public static String name;
    public static boolean chars[];

    public static String getName() {
        String[] allName = {"hello", "car", "cat", "dog", "sunday", "covid19"};
        Random r = new Random();
        String s = allName[r.nextInt(allName.length)];
        chars = new boolean[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = false;
        }
        return s;
    }

    public static String find(char c) {
        String s = "";
        for (int i = 0; i < name.length(); i++) {
            if (chars[i] == true) {
                s = s + name.charAt(i);
            } else {

                if (c == name.charAt(i)) {
                    s = s + c;
                    chars[i] = true;
                } else {
                    s = s + "*";
                }
            }
        }
        return s;
    }

    public static boolean found() {
        boolean result = chars[0];
        for (int i = 1; i < chars.length; i++) {
            result = result & chars[i];
        }
        return result;
    }
    static int port = 2002;

    public static void main(String[] args) {
        name = getName();
        System.out.println("word: " + name);
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("waiting connection");
            Socket socket = server.accept();
            System.out.println("connect to" + socket.getRemoteSocketAddress());

            PrintStream outSocket = new PrintStream(socket.getOutputStream());
            outSocket.println(find('*'));//return *******
            System.out.println("-->" + find('*'));
            Scanner inSocket = new Scanner(socket.getInputStream());
            char guessed;
            int i = 0;
            while (i < name.length() && !found()) {

                guessed = inSocket.nextLine().charAt(0);
                System.out.println(guessed);
                if (i != name.length() - 1) {
                    outSocket.println(find(guessed));//return **-*-**;
                    System.out.println("-->" + find(guessed));
                }
                else{
                    find(guessed);
                    i++;
                    break;
                }
                i++;
            }
            if (i == name.length()&!found()) {
                outSocket.println("GAMEOVER");
            } else {
                outSocket.println("YOUWIN");
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
