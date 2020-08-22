package Fact;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moham
 */
public class Fact {

    static int factoriel(int n) {
        if(n<0)return -1;//error
        if(n==0)return 1;
        int fact = 1;
        for (int i = 2; i < n + 1; i = i + 1) {
            fact *= i;
        }
        return fact;
    }
}
