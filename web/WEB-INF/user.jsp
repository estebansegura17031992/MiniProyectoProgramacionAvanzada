<%-- 
    Document   : user
    Created on : Jun 28, 2018, 9:33:00 AM
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
        <script src="js/main.js" type="text/javascript"></script>
        
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
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
        <h1>Welcome ${user.getNombre()}</h1>
    </body>
</html>
