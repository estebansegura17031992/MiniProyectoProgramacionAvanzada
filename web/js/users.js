/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $.ajax({
        url: "/MiniProyectoProgramacionAvanzada/getAllUsers.json",
        method: "GET"
    }).done(function(response){
        var htmlTable = "";
        $.each(response,function(i,item){
            htmlTable = htmlTable + "<tr>"+
                            "<td>"+
                                item.nombre+
                            "</td>"+
                            "<td>"+
                                item.email+
                            "</td>"+
                            "<td>"+
                                item.password+
                            "</td>"+
                            "<td>"+
                                "<i id='show_"+item.idUser+"' class='far fa-eye showUser' style='font-size: 32px; margin-right: 5px;'></i>"+
                                "<i id='edit_"+item.idUser+"' class='fas fa-user-edit' style='font-size: 32px;'></i>"+
                                "<i id='delete_"+item.idUser+"' class='fas fa-trash-alt' style='font-size:32px; margin-left: 5px;'></i>"+
                            "</td>"+
                        "</tr>";
            
        })
        $("#userTable tbody").append(htmlTable);
        
        $.each(response,function(i,item){
            $('#show_'+item.idUser).on('click',function(){
                //#1 Traer la informacion requerida
                $.ajax({
                    url: "/MiniProyectoProgramacionAvanzada/getUser.json",
                    method: "GET",
                    data: {idUser: item.idUser}
                }).done(function(response){
                    console.log(response)
                    
                    $("#show-user-name").val(response.nombre);
                    $("#show-user-email").val(response.email);
                    $("#show-user-password").val(response.password);
                })
                
                //#2 Mostrar el modal
                $('#showUserModal').modal('show')
            });
            
            $('#edit_'+item.idUser).on('click',function(){
                //#1 Traer la informacion requerida
                $.ajax({
                    url: "/MiniProyectoProgramacionAvanzada/getUser.json",
                    method: "GET",
                    data: {idUser: item.idUser}
                }).done(function(response){
                    console.log(response)
                    
                    $("#edit-user-name").val(response.nombre);
                    $("#edit-user-email").val(response.email);
                    $("#edit-user-password").val(response.password);
                })
                
                $('#editUserModal').modal('show')
                
                
                 //Editar un usuario
                 $("#btn-edit").on('click',function(){
                    var nombre = $("#edit-user-name").val();
                    var email = $("#edit-user-email").val();
                    var password = $("#edit-user-password").val();
                     $.ajax({
                         url: " /MiniProyectoProgramacionAvanzada/editUser.json",
                         method: "POST",
                         data: {actualEmail: item.email, newNombre: nombre, newEmail: email, newPassword: password}
                     }).done(function(response){
                        
                     })
                 })
            });
            
            $('#delete_'+item.idUser).on('click',function(){
                $('#deleteUserModal').modal('show')
            });
        })
        
    })
     
     //Mostrar Modal Nuevo Usuario
     $('#showNewUser').on('click',function(){
         $('#newUserModal').modal('show')
     })
     
     
     
     //Agregar un usuario
     $("#btn-register").on('click',function(){
         
         var nombre = $("#user-name").val();
         var email = $("#user-email").val();
         var password = $("#user-password").val();
         console.log(nombre + " - " + email + " - " + password);
         $.ajax({
             url: "/MiniProyectoProgramacionAvanzada/insertUser.json",
             method: "POST",
             data: {nombre: nombre, email: email, password: password}
             
         }).done(function(response){
             
             if(response.complete == "true"){
                 
                var htmlTable =  "<tr>"+
                                       "<td>"+
                                           nombre+
                                       "</td>"+
                                       "<td>"+
                                           email+
                                       "</td>"+
                                       "<td>"+
                                           password+
                                       "</td>"+
                                       "<td>"+
                                           "<i class='far fa-eye' style='font-size: 32px; margin-right: 5px;'></i>"+
                                           "<i class='fas fa-user-edit' style='font-size: 32px;'></i>"+
                                           "<i class='fas fa-trash-alt' style='font-size:32px; margin-left: 5px;'></i>"+
                                       "</td>"+
                                   "</tr>";


                   $("#userTable tbody").append(htmlTable);
            }
         })
     })
     
     
});
