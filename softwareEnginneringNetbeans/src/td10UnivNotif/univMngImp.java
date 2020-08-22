/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td10UnivNotif;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author Moham
 */
public class univMngImp extends UnicastRemoteObject implements IunivMng {

    HashMap<String, Student> db = new HashMap();
    HashMap<String, IClientNotif> subList = new HashMap();

    public univMngImp() throws RemoteException {

    }

    @Override
    public void addStudent(Student student) throws RemoteException {
        if (db.containsKey(student.id)) {
            throw new RemoteException("Student already exist");
        }
        db.put(student.id, student);
        System.out.println("Add " + student);
    }

    @Override
    public void updateStudent(String id, int math, int physique, int info) throws RemoteException {
        Student st = db.get(id);
        if (st == null) {
            throw new RemoteException("Student already exist");
        }
        st.math = math;
        st.physique = physique;
        st.info = info;
        IClientNotif client = subList.get(id);
        if (client != null) {
            client.notifier("Avg=" + getAvNote(id));
        }
        System.out.println("Update " + id);

    }

    @Override
    public Student getStudentById(String id) throws RemoteException {
        Student st = db.get(id);
        if (st == null) {
            throw new RemoteException("Student do not exist");
        }

        return st;
    }

    @Override
    public double getAvNote(String id) throws RemoteException {
        Student st = db.get(id);
        if (st == null) {
            throw new RemoteException("Student  do not exist");
        }

        return (st.math + st.physique + st.info) / 3d;
    }

    @Override
    public void subscribe(String Id, IClientNotif client) throws RemoteException {
        Student st = db.get(Id);
        if (st == null) {
            throw new RemoteException("Student  do not exist");
        }
        subList.put(Id, client);
    }

}
