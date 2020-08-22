/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td4chat;

import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author Salah
 */
public class ReaderSocketGui extends Thread{
     Scanner inSocket;
     JTextArea area;

    public ReaderSocketGui(Scanner inSocket, JTextArea area) {
        this.inSocket = inSocket;
        this.area = area;
    }
     
    public void run()
    {
         while (true) {
            String datafromClient = inSocket.nextLine();
            area.append(">>"+datafromClient+"\n");
        }
    }
    
}
