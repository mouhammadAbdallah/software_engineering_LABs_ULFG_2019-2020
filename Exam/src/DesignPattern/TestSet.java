/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern;

/**
 *
 * @author Moham
 */
public class TestSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Set set=new Set();
       
       //test iterator
        System.out.println(set.hasNext());
        set.add(1);
        System.out.println(set.hasNext());
        System.out.println(set.next());
        System.out.println(set.hasNext());
        
        //test the class
        System.out.println(set.app(1));
        set.add(1);
        System.out.println(set.hasNext());//false mean 1 is not added because it is already exist
    }
    
}
