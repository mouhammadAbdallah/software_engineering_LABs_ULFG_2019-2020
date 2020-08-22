/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass_bank_RMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Moham
 */
public class Account implements IAccount,Serializable {

    int accountId;
    public int accountBalance;
    ArrayList<String> accountHistory;
    
    public Account(int id){
        accountId=id;
        accountBalance=0;
        accountHistory=new ArrayList();
        accountHistory.add("[*] this account of Id = "+accountId+" is created in "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))+" with Balance = 0 $");
    }
    
    @Override
    public void deposit(int s)  {
        accountBalance+=s;
        accountHistory.add("[+] an amount of "+s+" is added to this account in "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
    }

    @Override
    public void withdraw(int s) {
        if(s<=accountBalance){
            accountBalance-=s;
            accountHistory.add("[-] an amount of "+s+" is withdrawn from this account in "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        }
        else{
            accountHistory.add("[-] an amount of "+s+" is intended to be withdrawn from this account but the balance was not enough !!! in "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        }
    }

    @Override
    public int solde() {
        accountHistory.add("[*] Asking about the balance of this account and it was "+accountBalance+" in "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        return accountBalance;
    }

    @Override
    public ArrayList<String> getHistory() {
        accountHistory.add("[*] Asking about the history of this account in "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        return accountHistory;
    }

    @Override
    public int getId(){
        return accountId;
    }
    
    
    
}
