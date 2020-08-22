/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td1java;

import java.util.ArrayList;

/**
 *
 * @author Moham
 */
public class ArrayListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(5);
        arr.add(4);
        int s=0;
        System.out.println(arr);
        for(int i=0;i<arr.size();i++){
            s+=arr.get(i);
        }
        System.out.println(s);

    }

}
