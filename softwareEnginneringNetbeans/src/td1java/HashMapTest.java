/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td1java;

import java.util.HashMap;

/**
 *
 * @author Moham
 */
public class HashMapTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        
        hm.put(1,"Toto");
        hm.put(2,"Titi");
        
        System.out.println(hm);
        
        //search
        String objet=hm.get(1);
        System.out.println(objet);
    }
    
}
