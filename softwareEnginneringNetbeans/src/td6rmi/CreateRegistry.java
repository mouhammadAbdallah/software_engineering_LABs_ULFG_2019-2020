/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td6rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class CreateRegistry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            int port=2000;
            LocateRegistry.createRegistry(port);
            Scanner key=new Scanner(System.in);
            key.nextLine();
        } catch (RemoteException ex) {
            Logger.getLogger(CreateRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
