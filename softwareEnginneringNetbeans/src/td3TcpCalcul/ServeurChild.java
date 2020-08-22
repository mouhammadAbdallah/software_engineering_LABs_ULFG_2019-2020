
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td3TcpCalcul;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salah
 */
public class ServeurChild extends Thread {

    Socket socket;

    public ServeurChild(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
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
            Logger.getLogger(ServeurChild.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
