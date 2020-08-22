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
public class WelcomeDecorator implements IWelcome {

    Welcome w = new Welcome();

    @Override
    public void hello8AM() {
        w.hello8AM();
    }

    public void hello8PM() {
        System.out.println("Bonsoir");
    }

}
