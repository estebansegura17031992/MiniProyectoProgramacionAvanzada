<%-- 
    Document   : allUsers
    Created on : Jul 18, 2018, 11:16:12 AM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
        <script src="js/users.js" type="text/javascript"></script>
        
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="user.htm">Java Web Login Example</a>
              </div>
              <ul class="nav navbar-nav">
                <li><a href="user.htm">Home</a></li>
                <li><a href="edit.htm">Edit</a></li>
                <li><a href="allUsers.htm">Users</a></li>
                <li><a href="log_out.htm">Log Out</a></li>
              </ul>
            </div>
        </nav>
        
        <div class="container"> 
            <h1 style="display: inline; margin-right: 5px; margin-bottom: 10px;">Usuarios</h1>
            <i id="showNewUser" class="fas fa-user-plus" style="font-size: 32px;"></i>
            
            <table id = "userTable" class="table table-hover">
                <thead>     
                    <tr>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    
                </tbody>
            </table>
        </div>
        
        <div class="modal fade" id="newUserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h2 class="modal-title" id="exampleModalLabel">Agregar Usuario</h2>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-top: -46px !important;">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <form>
                    <div class="form-group">
                      <label for="user-name" class="col-form-label">Nombre:</label>
                      <input type="text" class="form-control" id="user-name">
                    </div>
                    <div class="form-group">
                      <label for="user-email" class="col-form-label">Email</label>
                      <input type="text" class="form-control" id="user-email">
                    </div>
                    <div class="form-group">
                      <label for="user-password" class="col-form-label">Password</label>
                      <input name="user-password" type="text" class="form-control" id="user-password">
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                  <button id="btn-register" type="button" class="btn btn-primary">Agregar</button>
                </div>
              </div>
            </div>
          </div>
        
         <div class="modal fade" id="showUserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h2 class="modal-title" id="exampleModalLabel">Ver Usuario</h2>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-top: -46px !important;">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <form>
                    <div class="form-group">
                      <label for="user-name" class="col-form-label">Nombre:</label>
                      <input type="text" class="form-control" id="show-user-name" disabled="">
                    </div>
                    <div class="form-group">
                      <label for="user-email" class="col-form-label">Email</label>
                      <input type="text" class="form-control" id="show-user-email" disabled="">
                    </div>
                    <div class="form-group">
                      <label for="user-password" class="col-form-label">Password</label>
                      <input name="user-password" type="text" class="form-control" id="show-user-password" disabled="">
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                </div>
              </div>
            </div>
          </div>
        
        
        <div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h2 class="modal-title" id="exampleModalLabel">Editar Usuario</h2>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-top: -46px !important;">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <form>
                    <div class="form-group">
                      <label for="user-name" class="col-form-label">Nombre:</label>
                      <input type="text" class="form-control" id="edit-user-name">
                    </div>
                    <div class="form-group">
                      <label for="user-email" class="col-form-label">Email</label>
                      <input type="text" class="form-control" id="edit-user-email">
                    </div>
                    <div class="form-group">
                      <label for="user-password" class="col-form-label">Password</label>
                      <input name="user-password" type="text" class="form-control" id="edit-user-password">
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                  <button id="btn-edit" type="button" class="btn btn-primary">Editar</button>
                </div>
              </div>
            </div>
          </div>
        
        <div class="modal fade" id="deleteUserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h2 class="modal-title" id="exampleModalLabel">Eliminar Usuario</h2>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-top: -46px !important;">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                   <h3>Desea eliminar el elemento seleccionado?</h3>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                  <button id="btn-delete" type="button" class="btn btn-primary">Si</button>
                </div>
              </div>
            </div>
          </div>
    </body>
    
</html>
