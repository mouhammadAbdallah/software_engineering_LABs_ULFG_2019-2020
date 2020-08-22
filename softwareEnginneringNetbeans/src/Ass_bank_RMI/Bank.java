/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass_bank_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author Moham
 */
public class Bank extends UnicastRemoteObject implements IBank {

    static int newAccountId;
    static HashMap<Integer, Account> allAccount;
    HashMap<Integer, IClientNotif> subList = new HashMap();

    public Bank() throws RemoteException {
        newAccountId = 0;
        allAccount = new HashMap();
    }

    @Override
    public Account create() throws RemoteException {
        newAccountId++;
        Account acc = new Account(newAccountId);
        allAccount.put(newAccountId, acc);
        return acc;
    }

    @Override
    public Account getAcccountByNumber(int accNb) throws RemoteException {
        return allAccount.get(accNb);
    }

    @Override
    public void UpdateAccount(int accNb, Account acc) throws RemoteException {
        allAccount.put(accNb, acc);
        IClientNotif client = subList.get(accNb);
        if (client != null && acc.accountBalance < 10) {
            client.notificate("[!] Notification Alert: you have less than 10 $");
        }

    }

    @Override
    public void subscribe(int Id, IClientNotif client) throws RemoteException {
        if (!subList.containsKey(Id)) {
            subList.put(Id, client);
        }
    }

}
