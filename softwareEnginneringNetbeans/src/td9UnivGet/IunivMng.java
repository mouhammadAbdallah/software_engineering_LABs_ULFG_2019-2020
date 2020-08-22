/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td9UnivGet;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Moham
 */
public interface IunivMng extends Remote {

    public void addStudent(Student student) throws RemoteException;

    public void updateStudent(String id,int math,int physique,int info) throws RemoteException;

    public Student getStudentById(String id) throws RemoteException;
    public double getAvNote(String id)throws RemoteException;
    public boolean isUpdated (String id)throws RemoteException;
}
