/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td8RmiSeri;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Moham
 */
public interface IunivMng extends Remote {

    public void addStudent(Student student) throws RemoteException;

    public void updateStudent(Student student) throws RemoteException;

    public Student getStudentById(String id) throws RemoteException;

}
