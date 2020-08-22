/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td5Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salah
 */
public class CalculUdpClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
             int portin = 4000;
            int portout = 3000;
            int max = 1000;
            String host="127.0.0.1";
            DatagramSocket socketIn = new DatagramSocket(portin);
             DatagramSocket socketout = new DatagramSocket();

            InetAddress server = InetAddress.getByName(host);
            DatagramSocket socket = new DatagramSocket();
            Scanner key = new Scanner(System.in);

            while (true) {
                byte[] Data = new byte[max]; // buffer vide
                System.out.println("Enter request: 2.3 plus 4.5");
                Data = key.nextLine().getBytes();
                DatagramPacket outPacket = new DatagramPacket(Data, Data.length, server, portout);
                socketout.send(outPacket);
                
                Data = new byte[max];
                DatagramPacket incomingPacket = new DatagramPacket(Data, Data.length);

                socketIn.receive(incomingPacket);
                int taille = incomingPacket.getLength();
                Data[taille] = '\0';
                String s = new String(Data);
                System.out.println("reponse:" + s);
            }

        } catch (SocketException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
