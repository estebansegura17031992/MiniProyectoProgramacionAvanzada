/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoprogramacionavanzada.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String  folder = "/WEB-INF";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        
        // Control de las acciones a realizar según el *.htm
        if(action.equals("/index.htm")){
            // Guardar un atributo en la petición
            request.setAttribute("saludo", "Bienvenido a Programacion Avanzada");
            // Mostrar index.jsp
            request.getRequestDispatcher(folder+"/index.jsp").
                    forward(request, response);
            
        }else if(action.equals("/register.htm")){
            request.getRequestDispatcher(folder+"/register.jsp").
                    forward(request, response);
            
        }else if(action.equals("/nuevoUsuario.htm")){
            int valida = 0;
            // Obtener campos de la página
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String activo = request.getParameter("activo");
            
            // Validación
            if(user== null || user.equals("")){
                request.setAttribute("errorUser", "Campo requerido");
                valida++;
                
            }
            if(pass==null || pass.equals("")){
                request.setAttribute("errorPass", "Campo requerido");
                valida++;
                
            }
            if(valida == 0){// Todo OK
                request.setAttribute("mensaje", "Usuario Creado correctamente");
                request.setAttribute("user", "");
                request.setAttribute("pass", "");
                request.setAttribute("activo", "");
                
            }else{// ERROR
                request.setAttribute("user", user);
                request.setAttribute("pass", "");
                request.setAttribute("activo", activo);
            }
            
            request.getRequestDispatcher(folder+"/usuario.jsp").
                    forward(request, response);
            
        }else{
            request.getRequestDispatcher(folder+"/error.jsp").
                    forward(request, response);
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
