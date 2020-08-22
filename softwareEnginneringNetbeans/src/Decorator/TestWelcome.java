/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;



/**
 *
 * @author Salah
 */
public class TestWelcome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IWelcome w=new Welcome();
        
        w.hello8AM();
        System.out.println("");
        

        WelcomeDecorator wd=new WelcomeDecorator();
        wd.hello8AM();
        wd.hello8PM();
    }
    
}
