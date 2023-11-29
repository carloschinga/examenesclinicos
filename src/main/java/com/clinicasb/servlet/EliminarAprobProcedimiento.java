/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.ProcedimientosCabeceraJpaController;
import com.clinicasb.dao.ProcedimientosDetalleJpaController;
import com.clinicasb.dao.ProcedimientosResultadosJpaController;
import com.clinicasb.dto.ProcedimientosCabecera;
import com.clinicasb.dto.ProcedimientosDetalle;
import com.clinicasb.dto.ProcedimientosDetallePK;
import com.clinicasb.dto.ProcedimientosResultados;
import com.clinicasb.dto.ProcedimientosResultadosPK;
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
@WebServlet(name = "EliminarAprobProcedimiento", urlPatterns = {"/eliminaraprobprocedimiento"})
public class EliminarAprobProcedimiento extends HttpServlet {

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

                ProcedimientosResultadosJpaController prDAO = new ProcedimientosResultadosJpaController();
                ProcedimientosResultadosPK prPK = new ProcedimientosResultadosPK(Integer.parseInt(invnum),
                        Integer.parseInt(numitm));
                ProcedimientosResultados pr = prDAO.findProcedimientosResultados(prPK);

                pr.setEstres("G");
                pr.setMedcod("0000");
                pr.setUsecodApr(null);
                pr.setFeccreApr(null);
                pr.setHostnameApr(null);
                prDAO.edit(pr);
                
                ProcedimientosDetallePK pdPK= new ProcedimientosDetallePK(Integer.parseInt(invnum),
                        Integer.parseInt(numitm));
                ProcedimientosDetalle pd= new ProcedimientosDetalle(pdPK);
                ProcedimientosDetalleJpaController pdDAO= new ProcedimientosDetalleJpaController();
                pd= pdDAO.findProcedimientosDetalle(pdPK);
                pd.setEstexa("G");
                pd.setExaapr("N");
                pdDAO.edit(pd);
                
                ProcedimientosCabeceraJpaController pcDAO= new ProcedimientosCabeceraJpaController();
                ProcedimientosCabecera pc= pcDAO.findProcedimientosCabecera(Integer.parseInt(invnum));
                pc.setEstord("G");
                pcDAO.edit(pc);
                out.print("{\"resultado\":\"ok\"}");
            } catch (Exception ex) {
                out.print("{\"resultado\":\"error\"}");
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
