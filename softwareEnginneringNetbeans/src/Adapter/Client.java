/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

/**
 *
 * @author Salah
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lampe l=new Lampe();
        l.on();
        l.on();
        l.off();
        //...
        //.....
        System.out.println("new Version");
        LampeAdap lad=new LampeAdap(l);
        lad.switchL();
        lad.switchL();
        lad.switchL();
    }
    
}
