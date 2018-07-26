package com.miniproyectoprogramacionavanzada.controllers;

import com.miniproyectoprogramacionavanzada.models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@WebServlet(name = "RestXML", urlPatterns = {"/RestXML"})
public class RestXML extends HttpServlet {
    
    public static final byte PETICION_GET = 0;    // SELECT
    public static final byte PETICION_POST = 1;   // INSERT
    public static final byte PETICION_PUT = 2;    // UPDATE
    public static final byte PETICION_DELETE = 3; // DELETE
    
    private byte tipoPeticion;
    
   private Users users  = new Users();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JAXBException {
        
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            // Set it to true if you need the JSON output to formatted
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            switch (tipoPeticion) {
                case PETICION_GET:
                    // Convertir a XML el contenido de items, generando el resultado en out
                    jaxbMarshaller.marshal(users, out);
                    
                    
                    break;
                case PETICION_POST:
                    // Escribir aquí las accciones para peticiones por POST
                    break;
                case PETICION_PUT:
                    // Escribir aquí las accciones para peticiones por PUT
                    break;
                case PETICION_DELETE:
                    // Escribir aquí las accciones para peticiones por DELETE
                    break;
                default:
                    break;
            }     
 
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tipoPeticion = PETICION_GET;
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(RestXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tipoPeticion = PETICION_POST;
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(RestXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tipoPeticion = PETICION_DELETE;
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(RestXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tipoPeticion = PETICION_PUT;
        try { 
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(RestXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
