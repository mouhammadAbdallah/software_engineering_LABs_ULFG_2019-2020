/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass_bank_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Moham
 */
public interface IAccount {

    public void deposit(int s) ;

    public void withdraw(int s) ;

    public int solde() ;

    public ArrayList<String> getHistory() ;
    
    public int getId();
}
