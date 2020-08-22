/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td5Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salah
 */
public class Receiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int port = 3000;
            int max = 1000;
            DatagramSocket socket = new DatagramSocket(port);

            while (true) {
                byte[] Data = new byte[max]; // buffer vide
                DatagramPacket incomingPacket = new DatagramPacket(Data, Data.length);

                socket.receive(incomingPacket);
                int taille = incomingPacket.getLength();
                Data[taille] = '\0';
                String s = new String(Data);
                System.out.println("msg:" + s);
            }

        } catch (SocketException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
