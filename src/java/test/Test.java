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
import services.MachineService;
import services.SalleService;

/**
 *
 * @author YASSINE
 */
public class Test {
    public static void main(String[] args){

            IDao<Machine> dao= new MachineService();
            IDao<Salle> dao2= new SalleService();
            
              //creation des salles
              dao2.create(new Salle("B1"));
              dao2.create(new Salle("B2"));
              dao2.create(new Salle("B3"));
                //creation des machines
              
             
              dao.create(new Machine("E500", "lenovo",5999.99,dao2.findById(1)));
              dao.create(new Machine("E200", "hp",5999.99,dao2.findById(1)));
              dao.create(new Machine("E400", "dell",4500.79,dao2.findById(2)));
              /*for(Machine m: dao.findAll())
              System.out.println(m);
              for(Salle s: dao2.findAll())
              System.out.println(s);*/
               for(Salle s : dao2.findAll()){
                   System.out.println("Salle  : "+s.getCode());
                   for(Machine m : s.getMachines())
                          System.out.println("\t"+m.getRef());
               }
       
       
    }
}
