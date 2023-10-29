/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Salle;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalleService;

/**
 *
 * @author Ismail
 */
@WebServlet(name = "SalleController", urlPatterns = {"/SalleController"})
public class SalleController extends HttpServlet {

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
                    ss.delete(ss.findById(id));
                    response.sendRedirect("Salles.jsp");
                    break;
                }
                case "update": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Salle updatedSalle = ss.findById(id);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Salles.jsp");
                    request.setAttribute("salle", updatedSalle);
                    dispatcher.forward(request, response);
                    break;
                }
                default: {
                    response.sendRedirect("/pages/Salles.jsp");
                }
            }
        } else if (request.getParameter("op").equals("Ajouter")) {
            String code = request.getParameter("code");
            ss.create(new Salle(code));
//            Salle newSalle = new Salle();
//            newSalle.setCode(code);
//            ss.create(newSalle);

        } else if (request.getParameter("op").equals("Modifier")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String code = request.getParameter("code");
            Salle s = ss.findById(id);
            s.setCode(code);
            ss.update(s);
        }
        response.sendRedirect("Salles.jsp");

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
        return "SalleController";
    }// </editor-fold>

}
