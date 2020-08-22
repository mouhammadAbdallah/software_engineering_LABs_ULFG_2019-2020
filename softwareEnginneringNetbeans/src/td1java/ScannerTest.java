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
public class ScannerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("n = ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();//or scan other type directly

        try {
            int n = Integer.parseInt(data);//we can parse to other type
            System.out.println("int = " + n);
        } catch (Exception e) {
            try {
                Double n = Double.parseDouble(data);
                System.out.println("double = " + n);
            } catch (Exception ex) {
                System.out.println("String : " + data);
            }
        }
    }

}
