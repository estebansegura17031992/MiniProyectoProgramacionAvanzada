/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoprogramacionavanzada.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esteban
 */
@XmlRootElement (name="user")
public class User {
    
    private String idUser;
    private String nombre;
    private String email;
    private String password;

    public User(){
        
    }
    public User(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    
    public User(String idUser, String nombre, String email, String password) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    @XmlElement
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getIdUser() {
        return idUser;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
