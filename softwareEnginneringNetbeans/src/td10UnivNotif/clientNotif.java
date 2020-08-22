/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td10UnivNotif;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Moham
 */
public class clientNotif extends UnicastRemoteObject implements IClientNotif{

    public clientNotif()throws RemoteException{
        
    }
    
    @Override
    public void notifier(String msg) throws RemoteException {
        System.out.println(msg);
    }
    
}
