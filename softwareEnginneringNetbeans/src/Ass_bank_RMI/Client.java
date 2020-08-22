/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass_bank_RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlElement;
import td10UnivNotif.IunivMng;

/**
 *
 * @author Moham
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            IBank proxyBank = (IBank) Naming.lookup("rmi://127.0.0.1:2000/bank");
            Scanner key = new Scanner(System.in);
            String commandLine;
            int id = 0;
            boolean ok = false;
            Account acc;

            System.out.println("Create an account with: \"c\" or open your account by id for exemple \"o 16\"");
            commandLine = key.nextLine().trim();

            if (commandLine.length() == 1 && commandLine.charAt(0) == 'c') {
                acc = proxyBank.create();
                id = acc.getId();
                System.out.println("--> successfully created your account of Id: " + id);
                ok = true;

            }
            if (commandLine.length() >= 3 && commandLine.charAt(0) == 'o') {
                id = Integer.parseInt(commandLine.split(" ")[1]);
                acc = proxyBank.getAcccountByNumber(id);
                if (acc == null) {
                    System.out.println("[!] this account does not exist");
                    return;
                } else {
                    ok = true;
                }
            }
            if (ok == true) {
                IClientNotif myclient = new clientNotif();
                proxyBank.subscribe(id, myclient);
                System.out.println("what you can do with your account are:");
                System.out.println("1) deposit an amount for exemple : \"d 100\"");
                System.out.println("2) withdraw an amount for exemple : \"w 100\"");
                System.out.println("3) your Balance : \"s\"");
                System.out.println("4) your History : \"h\"");
                System.out.println("5) logout from your account : \"L\"");
                String ANSI_RESET = "\u001B[0m";
                String ANSI_RED = "\u001B[31m";
                System.out.println(ANSI_RED + "To test the notification open the account from other client and withdrow money to attend 9 $ and you will see a blue notification here" + ANSI_RESET);
                boolean stop = false;
                while (!stop) {
                    commandLine = key.nextLine().trim();
                    acc = proxyBank.getAcccountByNumber(id);
                    switch (commandLine.charAt(0)) {
                        case 'd': {
                            try {
                                int amount = Integer.parseInt(commandLine.split(" ")[1]);
                                if (amount >= 0) {
                                    acc.deposit(amount);
                                    proxyBank.UpdateAccount(id, acc);
                                    System.out.println("--> Done");
                                } else {
                                    System.out.println("--> error in the logic");
                                }
                            } catch (Exception e) {
                                System.out.println("--> error in command line");
                            }
                            break;
                        }
                        case 'w': {
                            try {
                                int amount = Integer.parseInt(commandLine.split(" ")[1]);
                                if (amount >= 0) {
                                    acc.withdraw(amount);
                                    proxyBank.UpdateAccount(id, acc);
                                    if (amount > acc.solde()) {
                                        System.out.println("--> no wnough money!");
                                    } else {
                                        System.out.println("--> Done");
                                    }
                                } else {
                                    System.out.println("--> error in the logic");
                                }
                            } catch (Exception e) {
                                System.out.println("--> error in command line");
                            }
                            break;
                        }
                        case 's': {
                            System.out.println("--> " + acc.solde());
                            proxyBank.UpdateAccount(id, acc);
                            break;
                        }
                        case 'h': {
                            ArrayList<String> history = acc.getHistory();
                            System.out.println("--> history:");
                            for (String histItem : history) {
                                System.out.println("     * " + histItem);
                            }
                            proxyBank.UpdateAccount(id, acc);
                            break;
                        }
                        case 'L': {
                            stop = true;
                            System.exit(0);

                        }
                        default: {
                            System.out.println("[!] Unknown command");
                            break;
                        }

                    }
                }
            } else {
                System.out.println("[!] Unknown command");
            }

        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
