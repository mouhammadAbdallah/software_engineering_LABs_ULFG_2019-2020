/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td9UnivGet;

import java.io.Serializable;

/**
 *
 * @author Moham
 */
public class Student implements Serializable{
    String name;
    String id;
    transient String password;
    int math,physique,info;

    public Student(String name,String id, String password) {
        this.name = name;
        this.password = password;
        math=physique=info=0;
        this.id=id;
        
    } 

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", password=" + password + ", math=" + math + ", physique=" + physique + ", info=" + info + '}';
    }
    public void updateNote(int math,int physique,int info){
        this.math=math;
        this.physique=physique;
        this.info=info;
    }
}
