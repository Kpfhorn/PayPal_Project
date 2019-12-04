/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project;

import com.mycompany.paypal_project.db.Activities;
import com.mycompany.paypal_project.db.ActivitiesService;
import com.mycompany.paypal_project.db.RoadmapActivitiesService;
import com.mycompany.paypal_project.db.Roadmapactivities;
import com.mycompany.paypal_project.db.RoadmapsService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kpfho
 */
@WebServlet(name = "ActivityServlet", urlPatterns = {"/ActivityServlet"})
public class ActivityServlet extends HttpServlet {
    
    @EJB
    private ActivitiesService acService;
    @EJB
    private RoadmapsService rmService;
    @EJB
    private RoadmapActivitiesService raService;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            int rmID = Integer.decode(request.getParameter("rmID").trim());
            Activities a = new Activities();
            a.setActivityID(acService.getNewID());
            a.setActivityName(name);
            acService.addActivities(a);
            Roadmapactivities ra = new Roadmapactivities(rmID, a.getActivityID());
            raService.addActivity(ra);
            out.println("OK");
        }
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
        return "Short description";
    }// </editor-fold>

}
