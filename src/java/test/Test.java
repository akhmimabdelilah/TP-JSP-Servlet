/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;

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

        for (Machine m : dao.findAll()) {
            System.out.println(m);
        }

    }
}
