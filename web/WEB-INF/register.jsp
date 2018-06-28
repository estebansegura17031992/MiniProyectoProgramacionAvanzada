<%-- 
    Document   : register
    Created on : Jun 27, 2018, 10:33:10 PM
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
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div id="register-container" class="container">
        <h1>Register</h1>
	<form action="nuevoUsuario.htm" method="POST">
		<div class="form-group">
			<label for="username" class="form-label">Username</label>
			<input type="text" name="username" class="form-control" id="username" placeholder="Username" required>
		</div>

		<div class="form-group">
			<label for="email" class="form-label">Email</label>
			<input type="text" name="email" class="form-control" id="email" placeholder="Email" required>
		</div>

		<div class="form-group">
			<label for="password" class="form-label">Password</label>
			<input type="password" name="password" class="form-control" id="password" placeholder="Password" required>
		</div>

		<div class="form-group">
			<a class="btn btn-danger btn-register" href="index.htm">Back</a>
			<button id="btn-register" type="submit" class="btn btn-success btn-register">Register</button>
		</div>
            </form>
        </div>
    </body>
</html>

