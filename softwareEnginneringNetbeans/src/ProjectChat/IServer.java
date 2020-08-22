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
public interface IServer extends Remote {

    public void reconnect(String id, IClient client) throws RemoteException;

    public void disconnect(String id) throws RemoteException;

    public void send(String msg, String id) throws RemoteException;

    public String listConnected() throws RemoteException;

}
