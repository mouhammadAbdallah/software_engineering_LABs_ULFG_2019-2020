/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td10UnivNotif;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Moham
 */
public interface IClientNotif extends Remote{
    public void notifier(String msg)throws RemoteException;
    
}
