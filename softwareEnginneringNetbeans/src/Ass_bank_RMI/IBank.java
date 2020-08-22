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
public interface IBank extends Remote {

    public Account create() throws RemoteException;

    public Account getAcccountByNumber(int accNb) throws RemoteException;

    public void UpdateAccount(int accNb,Account acc) throws RemoteException;
    public void subscribe(int Id,IClientNotif client)throws RemoteException;
}
