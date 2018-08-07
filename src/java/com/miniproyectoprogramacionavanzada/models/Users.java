package com.miniproyectoprogramacionavanzada.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class Users {
    UserDataUtil users  = new UserDataUtil(new ArrayList<User>());
    
    private static final String SUCCESS_RESULT="<result>success</result>";
    
    private List<User> userList;
    
    public Users() {
        userList = new ArrayList();
    }
 
    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsersList() {
        userList = users.getUsers();
        return userList;
    }
 
    @GET
    @Path("/users/{userid}")
    @Produces(MediaType.APPLICATION_XML)
    public User getUser(@PathParam("userid") int userid){
       return users.getUserByID(""+userid);
    }
    
    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createUser(@FormParam("id") String id,
       @FormParam("name") String name,
       @FormParam("profession") String profession,
       @Context HttpServletResponse servletResponse) throws IOException{
       User user = new User(id, name, profession);
       users.saveUserByEmail(user);
       return SUCCESS_RESULT;
    }
}

