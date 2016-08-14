<%-- 
    Document   : cabecera
    Created on : 10/08/2016, 02:25:58 PM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilosMenu.css">
    </head>
    <body>
        
            <h2 class="titulo">Bienvenido! ${sessionScope.usuario.nombres}<h2>
            <!--<a href="LogonSalir">Salir</a>-->
        
    </body>
</html>
