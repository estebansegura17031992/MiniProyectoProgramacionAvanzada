<%-- 
    Document   : index
    Created on : Jun 21, 2018, 12:14:35 PM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>${saludo}</h3>
        
        <h3>Menú</h3>
        <form action="prepareUser.htm" method="post">
            <input type="submit" value="Nuevo Usuario" />
        </form>
        
    </body>
</html>
