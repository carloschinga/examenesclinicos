/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clinicasb.servlet;

import com.clinicasb.dao.ViewWebMenuDetaJpaController;
import com.clinicasb.dao.WebMenuJpaController;
import com.clinicasb.dto.ViewWebMenuDeta;
import com.clinicasb.dto.WebMenu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "Menu", urlPatterns = {"/menu"})
public class Menu extends HttpServlet {

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
            String resultado="";
            HttpSession session = request.getSession(true);
            String codi=session.getAttribute("codi").toString();
            
            
            ViewWebMenuDetaJpaController webMenuDetaDAO= new ViewWebMenuDetaJpaController();
            List<ViewWebMenuDeta> lista= webMenuDetaDAO.listarMenuXUsua(Integer.parseInt(codi));
            for (ViewWebMenuDeta webMenuDeta : lista) {
                if(webMenuDeta.getTipmen().equals("T")){ //TITULO
                    resultado+="<div class=\"sidebar-heading\">"+webMenuDeta.getNommen()+"</div>";
                } 
                 
                    
                if(webMenuDeta.getTipmen().equals("M")){ //MENU
                    resultado+="<li class=\"nav-item\"><a class=\"nav-link\" href=\""+webMenuDeta.getHtml()+"\"><i class=\""+webMenuDeta.getIclass()+"\"></i><span>"+webMenuDeta.getNommen()+"</span></a></li>";
                }
                
                if(webMenuDeta.getTipmen().equals("-")){ //Separador
                    resultado+="<hr class=\"sidebar-divider\">";
                }
                                
            }
            out.print(resultado);
            
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
