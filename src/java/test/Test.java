/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;

/**
 *
 * @author akhmim
 */
public class Test {

    public static void main(String[] args) {
//        HibernateUtil.getSessionFactory();
        IDao<Machine> dao;

        dao = new MachineService();
//        dao.create(new Machine("ER44", "HP", 1000));
//        dao.create(new Machine("ER46", "LENOVO", 3000));
//        dao.create(new Machine("ER48", "ASUS", 5000));
        SalleService ss = new SalleService();
        MachineService ms = new MachineService();
        Salle s1 = new Salle("s1");
        Salle s2 = new Salle("s2");
        Salle s3 = new Salle("s3");
        Salle s4 = new Salle("s4");

//        ss.create(s1);
//        ss.create(s2);
//        ss.create(s3);
        ss.create(s4);

        for (Salle s : ss.findAll()) {
            System.out.println(s);
        }

//        ms.create(new Machine("ER44", "HP", 1000, s1));
//        ms.create(new Machine("ER46", "LENOVO", 3000, s2));
//        ms.create(new Machine("ER48", "ASUS", 5000, s3));
        ms.create(new Machine("ER50", "DELL", 9000, s4));

        for (Machine m : ms.findAll()) {
            System.out.println(m);

        }
        for (Machine m : dao.findAll()) {
            System.out.println(m);
        }

    }
}
