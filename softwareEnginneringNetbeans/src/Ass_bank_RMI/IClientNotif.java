/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass_bank_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Moham
 */
public interface IClientNotif extends Remote{
    public void notificate(String msg)throws RemoteException;
    
}
