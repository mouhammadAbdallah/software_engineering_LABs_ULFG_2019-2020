/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IterartorJava;

import java.util.Random;

/**
 *
 * @author Salah
 */
public class TestEtudiants {

    public static void main(String[] args) {
        // TODO code application logic here
        Etudiants etus = new Etudiants();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            etus.ajout("Eud" + i, 20 + r.nextInt(50));
        }

        double max = 50;
        String nom = "";
        for (Etudiant etu : etus) {
            if (etu.avg > max) {
                nom = etu.getNom();
                max = etu.getAvg();
            }
        }

        System.out.println("Name=" + nom + " Avg=" + max);

    }
}
