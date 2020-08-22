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
public class LampeAdap {
    Lampe l;
    boolean state=true;
    public LampeAdap(Lampe l)
    {
        this.l=l;
    }
    
    public void switchL()
    {
        if(state)
            l.on();
        else
            l.off();
        state=!state;
    }
    
    
}
