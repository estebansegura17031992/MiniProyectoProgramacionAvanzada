/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoprogramacionavanzada.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class UserDataUtil {
    private List<User> users;

    public UserDataUtil(List<User> users) {
        this.users = users;
        
        users.add(new User("Esteban Segura", "esteban.1703@gmail.com", "123"));
        users.add(new User("Carlos Jimenez", "carlos1992@gmail.com", "123"));
        users.add(new User("Adrian Hernandez", "adrian@gmail.com", "123"));
    }
    
    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers() {
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
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                users.get(i).setNombre(user.getNombre());
                users.get(i).setEmail(user.getEmail());
                users.get(i).setPassword(user.getPassword());
                System.out.println(users.get(i).getNombre());
                System.out.println(users.get(i).getEmail());
                System.out.println(users.get(i).getPassword());
                return 1;
            }
        }
        return 0;
    }
    
    
}
