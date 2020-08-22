/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td7RmiException;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moham
 */
public class serverCAlcul {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ICalcul cal =new CalculImp();
            Naming.rebind("rmi://127.0.0.1:2000/calcul",cal);
            System.out.println("clients  wainting....");
        } catch (RemoteException ex) {
            Logger.getLogger(serverCAlcul.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(serverCAlcul.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
