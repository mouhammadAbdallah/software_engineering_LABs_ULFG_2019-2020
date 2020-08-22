/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td6rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Ihello proxy=(Ihello)Naming.lookup("rmi://127.0.0.1:2000/hello");
            System.out.println("proxy: "+proxy);
            
            Scanner key=new Scanner(System.in);
            while(true){
            System.out.println("Name: ");
            String name=key.nextLine();
            
            String respons=proxy.sayHello(name);
            System.out.println("Respone:" +respons);
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
