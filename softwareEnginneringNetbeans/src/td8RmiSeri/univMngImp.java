/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td8RmiSeri;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author Moham
 */
public class univMngImp extends UnicastRemoteObject implements IunivMng {

    static HashMap<String, Student> db = new HashMap();

    public univMngImp() throws RemoteException {

    }

    @Override
    public void addStudent(Student student) throws RemoteException {
        if (db.containsKey(student.id)) {
            throw new RemoteException("Student already exist");
        }
        db.put(student.id, student);
        System.out.println("Add "+student);
    }

    @Override
    public void updateStudent(Student student) throws RemoteException {
        Student st = db.get(student.id);
        if (st == null) {
            throw new RemoteException("Student already exist");
        }
        st.math=student.math;
        st.physique=student.physique;
        st.info=student.info;
        System.out.println("Update "+student);

    }

    @Override
    public Student getStudentById(String id) throws RemoteException {
                Student st = db.get(id);
        if (st == null) {
            throw new RemoteException("Student already exist");
        }
        return st;
    }

}
