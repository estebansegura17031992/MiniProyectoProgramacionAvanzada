package com.miniproyectoprogramacionavanzada.controllers;

import com.miniproyectoprogramacionavanzada.models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestJSON extends HttpServlet {

    public static final byte PETICION_GET = 0;    // SELECT
    public static final byte PETICION_POST = 1;   // INSERT
    public static final byte PETICION_PUT = 2;    // UPDATE
    public static final byte PETICION_DELETE = 3; // DELETE
    
    private byte tipoPeticion;
    
   private Users users  = new Users();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RestJSON</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RestJSON at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tipoPeticion = PETICION_GET;
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tipoPeticion = PETICION_POST;
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tipoPeticion = PETICION_DELETE;
        processRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tipoPeticion = PETICION_PUT;
        processRequest(request, response);
    }
    
    
}
