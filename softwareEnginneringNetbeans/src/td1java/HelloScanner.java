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
public class HelloScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String name;
        System.out.println("name:");
        Scanner scanner=new Scanner(System.in);
        name=scanner.nextLine();
        System.out.println("Hello "+name);
        
    }
    
}
