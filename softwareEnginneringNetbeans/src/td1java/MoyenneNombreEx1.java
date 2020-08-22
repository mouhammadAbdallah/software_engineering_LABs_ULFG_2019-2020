/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td1java;

import java.util.Scanner;

/**
 *
 * @author Moham
 */
public class MoyenneNombreEx1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("5 Integer seperated by Enter");
        Scanner scan=new Scanner(System.in);
        Double mean;
        int sum=0;
        for(int i=1;i<=5;i++){
            System.out.print("int1 = ");
            sum+=scan.nextInt();
        }
        System.out.println("mean = "+ sum/5.0);
    }
    
}
