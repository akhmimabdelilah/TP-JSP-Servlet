/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Machine;
import entities.Salle;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MachineService;
import service.SalleService;

/**
 *
 * @author akhmim
 */
@WebServlet(name = "MachineController", urlPatterns = {"/MachineController"})
public class MachineController extends HttpServlet {

    MachineService ms = new MachineService();
    SalleService ss = new SalleService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("op") != null) {
            switch (request.getParameter("op")) {
                case "delete": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    ms.delete(ms.findById(id));
                    break;
                }
                case "update": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String ref = request.getParameter("ref");
                    String marque = request.getParameter("marque");
                    double prix = Double.parseDouble(request.getParameter("prix"));
                    Salle salle = ss.findById(Integer.parseInt(request.getParameter("salleId")));
                    Machine updatedMachine = ms.findById(id);
                    updatedMachine.setId(id);
                    updatedMachine.setRef(ref);
                    updatedMachine.setMarque(marque);
                    updatedMachine.setPrix(prix);
                    updatedMachine.setSalle(salle);
                    ms.update(updatedMachine);
                    break;
                }
                default: {
                    response.sendRedirect("/pages/Machines.jsp");
                }
            }
        } else {
            String ref = request.getParameter("ref");
            String marque = request.getParameter("marque");
            double prix = Double.parseDouble(request.getParameter("prix"));
//            Salle salle = ss.findById(Integer.parseInt(request.getParameter("salleId")));
            Salle salle = ss.findById(Integer.parseInt(request.getParameter("salleId")));

            ms.create(new Machine(ref, marque, prix, salle));
        }
        response.sendRedirect("/pages/Machines.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "MachineController";
    }// </editor-fold>

}
