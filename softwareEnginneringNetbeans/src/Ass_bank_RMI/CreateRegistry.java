/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass_bank_RMI;

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

            System.out.println("[*] Creating Registry ...");
            LocateRegistry.createRegistry(2000);
            System.out.println("[+] Registry is successfully created ");
            System.out.println("...");
            new Scanner(System.in).nextLine();
            
        } catch (RemoteException ex) {
            Logger.getLogger(CreateRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
