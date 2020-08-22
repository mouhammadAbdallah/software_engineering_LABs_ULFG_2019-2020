/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectChat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author Salah
 */
public class ServerImp extends UnicastRemoteObject implements IServer {

    HashMap<String, IClient> listConnected = new HashMap();
    HashMap<String, String> offLineMsg = new HashMap();

    public ServerImp() throws RemoteException {

    }

    @Override
    public void reconnect(String id, IClient client) throws RemoteException {
        listConnected.put(id, client);
        System.out.println("connect "+id);
        String msg=offLineMsg.get(id);
        if(msg!=null)
        {
            client.notifier(msg);
            offLineMsg.put(id,null);
        }
    }

    @Override
    public void disconnect(String id) throws RemoteException {
        listConnected.remove(id);
    }

    @Override
    public void send(String msg, String id) throws RemoteException {
        IClient cl = listConnected.get(id);
        if (cl != null) {
            // client online
            cl.notifier(msg);
             System.out.println("send "+id);
        } else {
            //client offline
            String oldmsg = offLineMsg.get(id);
            if (oldmsg == null) {
                oldmsg = "";
            }
            oldmsg += "," + msg;
            offLineMsg.put(id, oldmsg);
            System.out.println("put "+id);
        }

    }

    @Override
    public String listConnected() throws RemoteException {
        return listConnected.keySet().toString();
    }
    
}
