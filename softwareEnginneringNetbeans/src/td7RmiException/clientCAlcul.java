/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td7RmiException;

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
public class clientCAlcul {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ICalcul cal = (ICalcul) Naming.lookup("rmi://127.0.0.1:2000/calcul");
            Scanner key = new Scanner(System.in);
            System.out.println("add a b");
            int res = cal.sum(key.nextInt(), key.nextInt());
            key.nextLine();
            System.out.println("sum=" + res);

            System.out.println("div a b");
            double resu = cal.div(key.nextInt(), key.nextInt());
            key.nextLine();
            System.out.println("div=" + resu);

        } catch (NotBoundException ex) {
            Logger.getLogger(clientCAlcul.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(clientCAlcul.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            System.out.println("Excep:"+ex.getMessage());
        }
    }

}
