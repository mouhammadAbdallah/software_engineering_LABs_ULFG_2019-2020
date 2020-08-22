/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td6rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Moham
 */
public class Helloimp extends UnicastRemoteObject implements Ihello {//UnicastRemoteObject using TCP

    public Helloimp()throws RemoteException{
        
    }
    public String sayHello(String name) throws RemoteException {
        return "hello " + name;
    }

}
