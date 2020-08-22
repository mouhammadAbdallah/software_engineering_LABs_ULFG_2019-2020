/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td8RmiSeri;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
            Student st = new Student("mohamad", "st1", "123456");
            proxy.addStudent(st);
            System.out.println("before update: " + proxy.getStudentById("st1"));
            st.math = 80;
            st.physique = 90;
            st.info = 70;
            proxy.updateStudent(st);
            System.out.println("after update: " + proxy.getStudentById("st1"));

            
        } catch (NotBoundException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
