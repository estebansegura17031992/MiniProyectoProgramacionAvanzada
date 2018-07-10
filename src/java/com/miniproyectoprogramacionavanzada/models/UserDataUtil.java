/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoprogramacionavanzada.models;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class UserDataUtil {
    private static MySqlConnection conexion;
    private List<User> users;

    public UserDataUtil(List<User> users) {
        this.users = users;
        
        //users.add(new User("Esteban Segura", "esteban.1703@gmail.com", "123"));
        //users.add(new User("Carlos Jimenez", "carlos1992@gmail.com", "123"));
        //users.add(new User("Adrian Hernandez", "adrian@gmail.com", "123"));
    }
    
    public static void addUser(User user){
        //users.add(user);
        
        //Cargando la conexion
        conexion = new MySqlConnection();
        Connection conn;
        conn = conexion.getConnection();
        
        Statement st;
        
        //Creamos el SQL
        String sql = "INSERT INTO users(nombre,email,password) values ('"+user.getNombre()+"','"+user.getEmail()+"','"+user.getPassword()+"')";
        
        //Se ejecuta la sentencia SQL
        try{
            st = (Statement) conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
            st.close();
        } catch(SQLException e){
            System.out.println("Error insertando: "+e.getMessage());
        }
    }

    public List<User> getUsers() {
        //Cargando la conexion
        conexion = new MySqlConnection();
        Connection conn;
        conn = conexion.getConnection();
        
        Statement st;
        ResultSet rs;
        
        //Creamos el SQL
        String sql = "SELECT * FROM users";
        
        //Se ejecuta la sentencia SQL
        try{
            st = (Statement) conn.createStatement();
            rs = st.executeQuery(sql);
            
            //Se recorren los datos obtenidos del SQL 
            while(rs.next()){
                User user = new User(rs.getString(2),rs.getString(3),rs.getString(4));
                users.add(user);
            }
            
            //Se cierra la conexion
            conn.close();
            st.close();
        } catch(SQLException e){
            System.out.println("Error getUsers: "+e.getMessage());
        }
        
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public int size(){
        return users.size();
    }
    
    public User get(int i){
        return users.get(i);
    }
    
    public int saveUserByEmail(User user){
        
        /*for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                users.get(i).setNombre(user.getNombre());
                users.get(i).setEmail(user.getEmail());
                users.get(i).setPassword(user.getPassword());
                System.out.println(users.get(i).getNombre());
                System.out.println(users.get(i).getEmail());
                System.out.println(users.get(i).getPassword());
                return 1;
            }
        }*/
        
        int confirmar = 0;
        //Cargando la conexion
        conexion = new MySqlConnection();
        Connection conn;
        conn = conexion.getConnection();
        
        Statement st;
        
        //Creamos el SQL
        String sql = "UPDATE users "
                + "SET nombre = '"+user.getNombre()+"',email = '"+user.getEmail()+"',password='"+user.getPassword()+"' "
                + "WHERE email = '"+user.getEmail()+"'";
        System.out.println(sql);
        //Se ejecuta la sentencia SQL
        try{
            st = (Statement) conn.createStatement();
            confirmar = st.executeUpdate(sql);
            
            if(confirmar==1){
                System.out.println("Registro actuaizado"); 
            } else {
                System.out.println("Registro fallido");
            }
            //Se cierra la conexion
            conn.close();
            st.close();
        } catch(SQLException e){
            System.out.println("Error update: "+e.getMessage());
        }
        return confirmar;
    }
    
    
}
