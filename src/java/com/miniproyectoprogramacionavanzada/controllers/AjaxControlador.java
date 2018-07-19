/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoprogramacionavanzada.controllers;

import com.miniproyectoprogramacionavanzada.models.JsonObject;
import com.miniproyectoprogramacionavanzada.models.User;
import com.miniproyectoprogramacionavanzada.models.UserDataUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban
 */
public class AjaxControlador extends HttpServlet {
    UserDataUtil users  = new UserDataUtil(new ArrayList<User>());
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
        String action = request.getServletPath();
        System.out.println("accion:"+action );
        // Control de las acciones a realizar según el *.htm
        if(action.equals("/getAllUsers.json")){
            String jsonArray = "";
            String separator = "";
            List<User> actualUsers = users.getUsers();
            JsonObject jsonObject = new JsonObject();
            
            for (int i = 0; i < actualUsers.size(); i++) {
                Map<String, String> values = new TreeMap<String,String>();
                values.put("idUser",actualUsers.get(i).getIdUser());
                values.put("nombre", actualUsers.get(i).getNombre());
                values.put("email", actualUsers.get(i).getEmail());
                values.put("password", actualUsers.get(i).getPassword());
                String json = jsonObject.convertToJson(values);
                jsonArray = jsonArray + separator + json;
                separator = ",";
                
            }
            
            jsonArray = "["+jsonArray+"]";
            
            response.setContentType("application/json");
            
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(jsonArray);
            out.flush();
            
        } else if(action.equals("/insertUser.json")){
            //#1 Obtener parametros
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            //#2 ALmacenar en base de datos
            users.addUser(new User(nombre,email,password));
            
            //#3 Construir json
            JsonObject jsonObject = new JsonObject();
            
            Map<String, String> values = new TreeMap<String,String>();
            values.put("complete","true");
            values.put("message", "Usuario agregado correctamente");
            String json = jsonObject.convertToJson(values);
                
            //#4 Retornar json
            response.setContentType("application/json");
            
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(json);
            out.flush();
            
        } else if(action.equals("/getUser.json")){
            //#1 Obtener parametros
            String idUser = request.getParameter("idUser");
            
            //#2 Obtener usuario de la base de datos
            User user = users.getUserByID(idUser);
            
            //#3 Construir el json
            JsonObject jsonObject = new JsonObject();
            
            Map<String, String> values = new TreeMap<String,String>();
            values.put("idUser",user.getIdUser());
            values.put("nombre", user.getNombre());
            values.put("email", user.getEmail());
            values.put("password", user.getPassword());
            String json = jsonObject.convertToJson(values);
            
            //#4 Retornar json
            response.setContentType("application/json");
            
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(json);
            out.flush();
        } else if(action.equals("/editUser.json")){
            // #1 Obtener campos de la página
            String user = request.getParameter("newNombre");
            String email = request.getParameter("newEmail");
            String password = request.getParameter("newPassword");
            
            // #2 Editar en la base de datos
            users.saveUserByEmail(new User(user,email,password));
            
            //#3 Construir json
            JsonObject jsonObject = new JsonObject();
            
            Map<String, String> values = new TreeMap<String,String>();
            values.put("complete","true");
            values.put("message", "Usuario editado correctamente");
            String json = jsonObject.convertToJson(values);
                
            //#4 Retornar json
            response.setContentType("application/json");
            
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = response.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(json);
            out.flush();
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
