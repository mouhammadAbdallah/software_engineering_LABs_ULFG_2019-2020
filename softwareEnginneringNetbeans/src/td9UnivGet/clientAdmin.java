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
public class clientAdmin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            IunivMng proxy = (IunivMng) Naming.lookup("rmi://127.0.0.1:2000/univ");
            Scanner key = new Scanner(System.in);
            while (true) {
                System.out.println("Add or Update: a u");
                String oper = key.nextLine();
                switch (oper) {
                    case "a":
                        System.out.println("name?");
                        String name = key.nextLine();
                        System.out.println("id?");
                        String id = key.nextLine();
                        Student st=new Student(name, id.trim(), "123456");
                        proxy.addStudent(st);
                        break;
                    case "u":
                        System.out.println("id?");
                        id = key.nextLine().trim();
                        System.out.println("math physique info?");
                        int m=key.nextInt();
                        int p=key.nextInt();
                        int i=key.nextInt();
                        key.nextLine();
                        proxy.updateStudent(id,m,p,i);
                        break;
                }
            }

        } catch (NotBoundException ex) {
            Logger.getLogger(clientAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(clientAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(clientAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
