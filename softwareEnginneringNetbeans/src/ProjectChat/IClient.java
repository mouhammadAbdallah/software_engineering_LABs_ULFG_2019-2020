/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectChat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Salah
 */
public interface IClient extends Remote{
    public void notifier(String msg) throws RemoteException;
    
}
