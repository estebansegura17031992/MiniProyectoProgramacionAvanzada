<%-- 
    Document   : index
    Created on : Jun 21, 2018, 12:14:35 PM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
        <script src="js/main.js" type="text/javascript"></script>
        
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <h3 id="registroCompleto" hidden>${saludo}</h3>
        
        <div class="container">
            <h1>Login</h1>
            <div id="alertLogin" class="alert alert-success alert-dismissible" role="alert">
              Login Completo
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div id="alertRegistro" class="alert alert-success alert-dismissible" role="alert">
              Registro Completo
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div id="alertFail" class="alert alert-danger alert-dismissible" role="alert">
              Usuario o Password Fallido. Intentelo nuevamente!
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div id="login-cart-div">
                <form action="login.htm" method="POST">
                    <div class="login-input form-group">
			<label for="email" class="form-label">Email</label>
			<input type="text" name="email" id="email" class="form-control">
                    </div>
                    <div class="login-input form-group">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" name="password" id="password" class="form-control">
                    </div>
                    <button class="btn btn-success btn-login" type="submit">Login</button>
		</form>
            </div>
            <div id="div-register">
                    Don't you have an account?... <a  href="register.htm">Register</a>
            </div>
        </div>
        
    </body>
</html>