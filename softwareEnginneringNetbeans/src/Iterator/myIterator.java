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
public class myIterator implements IMyIterator{
    Etudiants etuds;
    int count;

    public myIterator(Etudiants etuds) {
        this.etuds = etuds;
        count=0;
    }

    @Override
    public boolean hasNext() {
        if(count==etuds.name.length)
            return false;
        else
            return true;
    }

    @Override
    public Etudiant next() {
        Etudiant et=new Etudiant(etuds.name[count],etuds.avg[count]);
        count++;
        return et;
    }
    
    
}
