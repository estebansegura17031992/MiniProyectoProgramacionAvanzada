/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoprogramacionavanzada.controllers;

import com.miniproyectoprogramacionavanzada.models.User;
import com.miniproyectoprogramacionavanzada.models.UserDataUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
    private User actualUser=null;
    UserDataUtil users  = new UserDataUtil(new ArrayList<User>());
    
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
            // Obtener campos de la página
            String user = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            users.addUser(new User(user,email,password));
            request.setAttribute("saludo", "registro");
            request.getRequestDispatcher(folder+"/index.jsp").
                    forward(request, response);
            
        } else if(action.equals("/login.htm")){
           List<User> actualUsers = users.getUsers();
        
            String user = request.getParameter("email");
            String pass = request.getParameter("password");
            boolean isValid = false;
            
            for (int i = 0; i < actualUsers.size(); i++) {
                System.out.println(actualUsers.get(i).getNombre());
                if (user.equals(actualUsers.get(i).getEmail())) {
                    System.out.println(actualUsers.get(i).getPassword());
                    System.out.println(pass);
                    if (pass.equalsIgnoreCase(actualUsers.get(i).getPassword())) {
                        isValid = true;
                        actualUser = actualUsers.get(i);
                    }
                }
            }
            System.out.println(isValid);
            if(isValid == true){
                request.getRequestDispatcher(folder+"/authentication.jsp")
                                .forward(request,response);
                
            } else {
                request.setAttribute("saludo", "login");
                request.getRequestDispatcher(folder+"/index.jsp").
                    forward(request, response);

            }
        } else if(action.equals("/user.htm")){
            request.setAttribute("user", actualUser);
            request.getRequestDispatcher(folder+"/user.jsp")
                            .forward(request,response);
        } else if(action.equals("/log_out.htm")){
            actualUser = null;
            request.getRequestDispatcher(folder+"/logOut.jsp")
                            .forward(request,response);
        } else if(action.equals("/edit.htm")){
            request.setAttribute("user", actualUser);
            
            request.getRequestDispatcher(folder+"/edit.jsp")
                    .forward(request, response);
        }else if(action.equals("/editarUsuario.htm")){
            request.setAttribute("user", actualUser);
            
            // Obtener campos de la página
            String user = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            actualUser.setNombre(user);
            actualUser.setEmail(email);
            actualUser.setPassword(password);
            
            users.saveUserByEmail(new User(user,email,password));
            
            request.setAttribute("saludo", "editar");
            request.getRequestDispatcher(folder+"/editarUsuario.jsp").
                    forward(request, response);
        } else{
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
