/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td9UnivGet;

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
            IunivMng proxy = (IunivMng) Naming.lookup("rmi://127.0.0.1:2000/univ");
            Scanner key = new Scanner(System.in);
            while (true) {
                System.out.println("get avg by id?");
                String id = key.nextLine().trim();

                (new Thread() {
                    public void run() {
                        double avg;
                        try {
                            while (true) {
                                Thread.sleep(2000);
                                if (proxy.isUpdated(id)) {

                                    avg = proxy.getAvNote(id);
                                    System.out.println("avg for studeny " + id + " =" + avg);
                                    break;

                                }

                            }
                        } catch (RemoteException ex) {
                            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();

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
