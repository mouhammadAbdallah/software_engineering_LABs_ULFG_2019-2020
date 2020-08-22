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
public class ArrayListObject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(5);
        arr.add(4);
        arr.add("2.3");

        int s = 0;
        System.out.println(arr);
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i) instanceof Integer) {
//                s += (int) arr.get(i);
//            }
//            else
//                System.out.println("not int "+arr.get(i));
//          
//        }

        for (Object o : arr) {//called iterator :kind of design pattern
            if (o instanceof Integer) {
                s += (int) o;
            } else {
                System.out.println("not int " + o);
            }

        }
        System.out.println(s);
    }

}
