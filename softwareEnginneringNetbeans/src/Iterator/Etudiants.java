/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

/**
 *
 * @author Salah
 */
public class Etudiants {
    protected String [] name=new String[100];
    protected double [] avg=new double [100];
    int n;
    public Etudiants()
    {
        n=0;
    }
    
    public void ajout(String nom,double m)
    {
        name[n]=nom;
        avg[n]=m;
        n++;
    }
    
    
}
