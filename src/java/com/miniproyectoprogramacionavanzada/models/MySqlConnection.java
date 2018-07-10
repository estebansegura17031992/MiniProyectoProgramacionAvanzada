/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoprogramacionavanzada.models;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author esteban
 */
public class MySqlConnection {
    private static String servidor = "jdbc:mysql://localhost/exampleBD";
    private static String user = "root";
    private static String pass = "";
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection conexion;

    public MySqlConnection() {
        try{
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(servidor,user,pass);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException ex){
            System.out.println("Conexion fallida");
        }
    }
    
    public Connection getConnection(){
        return conexion;
    }  
}
