/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td7RmiException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Moham
 */
public class CalculImp extends UnicastRemoteObject implements ICalcul{
    public CalculImp() throws RemoteException{
        
    }
    @Override
    public int sum(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public double div(int a, int b) throws RemoteException {
        
        if(b==0)
            throw new RemoteException("Division by zero");
        return (a*1.0)/b;
    }
    
    
}
