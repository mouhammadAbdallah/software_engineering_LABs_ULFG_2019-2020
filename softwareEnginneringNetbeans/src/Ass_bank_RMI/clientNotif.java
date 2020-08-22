/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass_bank_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Moham
 */
public class clientNotif extends UnicastRemoteObject implements IClientNotif {

    public clientNotif() throws RemoteException {

    }

    @Override
    public void notificate(String msg) throws RemoteException {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        System.out.println(ANSI_BLUE+ msg+ANSI_RESET);
    }

}
