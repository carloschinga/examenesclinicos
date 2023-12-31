/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.EaOrdenesCabeceraJpaController;
import com.clinicasb.dao.EaOrdenesDetalleJpaController;
import com.clinicasb.dao.EaResultadosJpaController;
import com.clinicasb.dto.EaOrdenesCabecera;
import com.clinicasb.dto.EaOrdenesDetalle;
import com.clinicasb.dto.EaOrdenesDetallePK;
import com.clinicasb.dto.EaResultados;
import com.clinicasb.dto.EaResultadosPK;
import com.clinicasb.dto.ProcedimientosDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "EliminarAprobEA", urlPatterns = {"/eliminaraprobea"})
public class EliminarAprobEA extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            try {
                String invnum = request.getParameter("invnum");
                String numitm = request.getParameter("numitm");

                EaResultadosJpaController earDAO = new EaResultadosJpaController();
                EaResultadosPK earPK = new EaResultadosPK(Integer.parseInt(invnum),
                        Integer.parseInt(numitm));
                EaResultados ear = earDAO.findEaResultados(earPK);

                ear.setEstres("G");
                ear.setMedcod("0000");
                ear.setUsecodApr(null);
                ear.setFeccreApr(null);
                ear.setHostnameApr(null);
                earDAO.edit(ear);

                EaOrdenesDetallePK pdPK = new EaOrdenesDetallePK(Integer.parseInt(invnum),
                        Integer.parseInt(numitm));
                EaOrdenesDetalle pd = new EaOrdenesDetalle(pdPK);
                EaOrdenesDetalleJpaController pdDAO = new EaOrdenesDetalleJpaController();
                pd = pdDAO.findEaOrdenesDetalle(pdPK);
                pd.setEstexa("G");
                pd.setExaapr("N");
                pdDAO.edit(pd);

                EaOrdenesCabeceraJpaController pcDAO = new EaOrdenesCabeceraJpaController();
                EaOrdenesCabecera pc = pcDAO.findEaOrdenesCabecera(Integer.parseInt(invnum));
                pc.setEstord("G");
                pcDAO.edit(pc);
                out.print("{\"resultado\":\"ok\"}");
            } catch (Exception ex) {
                out.print("{\"resultado\":\"error\",\"mensaje\":\"" + ex.getMessage() + "\"}");
            }
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
