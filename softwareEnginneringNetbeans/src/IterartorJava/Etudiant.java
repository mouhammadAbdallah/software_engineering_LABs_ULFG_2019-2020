/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IterartorJava;

/**
 *
 * @author Salah
 */
public class Etudiant {
   String nom;
    double avg;

    public Etudiant(String nom, double avg) {
        this.nom = nom;
        this.avg = avg;
    }

    public String getNom() {
        return nom;
    }

    public double getAvg() {
        return avg;
    }
    
}
