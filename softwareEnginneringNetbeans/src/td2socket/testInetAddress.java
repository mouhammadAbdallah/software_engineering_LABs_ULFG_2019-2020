/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td2socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class testInetAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("local host: " + local.toString());

            String host = local.getHostName();
            System.out.println("Local Host Name: " + host);
            System.out.print("Local Host IP: ");//if byte>128 it will be negative
            byte[] ip = local.getAddress();
            for (byte b : ip) {
                System.out.print(b + ".");
            }
            System.out.println();

            System.out.println("----------------------");

            String remoteHost = "www.google.com";
            InetAddress remote = InetAddress.getByName(remoteHost);
            System.out.println("Remote Host: " + remote.toString());

            System.out.println("----------------------");
            
            InetAddress[] allRemote = InetAddress.getAllByName("nba.com");
            for(InetAddress a:allRemote)
                System.out.println("Remote Host: "+a.toString());

        } catch (UnknownHostException ex) {
            Logger.getLogger(testInetAddress.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
