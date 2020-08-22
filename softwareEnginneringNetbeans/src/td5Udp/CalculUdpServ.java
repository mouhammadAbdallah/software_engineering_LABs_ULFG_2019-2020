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
public class CalculUdpServ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int portin = 3000;
            int portout = 4000;
            int max = 1000;
            DatagramSocket socketIn = new DatagramSocket(portin);
             DatagramSocket socketout = new DatagramSocket();

            while (true) {
                byte[] Data = new byte[max]; // buffer vide
                DatagramPacket incomingPacket = new DatagramPacket(Data, Data.length);

                socketIn.receive(incomingPacket);
                int taille = incomingPacket.getLength();
                Data[taille] = '\0';
                String s = new String(Data);
                System.out.println("msg:" + s);//3.2 plus 4.5
                
                String [] req=s.split("plus");
                double r=Double.parseDouble(req[0])+Double.parseDouble(req[1]);
                
                Data = new byte[max];
                Data=(new String(""+r)).getBytes();
                DatagramPacket outPacket = new DatagramPacket(Data, Data.length, incomingPacket.getAddress(), portout);

                socketout.send(outPacket);
                
            }

        } catch (SocketException ex) {
            Logger.getLogger(CalculUdpServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalculUdpServ.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
