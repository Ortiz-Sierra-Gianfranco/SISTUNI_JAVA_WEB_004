<%-- 
    Document   : loginProfesor
    Created on : 11/08/2016, 12:25:45 PM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,300' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        
        <title>COLEGIO</title>
    </head>
    <body>
        <div><jsp:include page="menuPrincipal.jsp"/></div>
    
        <c:if test="${requestScope.error != null }">
            <p>${requestScope.error}</p>
        </c:if>
            
        <div class="contenedor">
            <table>
                <tr>
                    <td class="ancho">
                        <img class="image-login" src="img/profesor.png" />
                    </td>
                    <td>
                         <h2 class="titulo">Profesores</h2>
                    </td>
                </tr>
            </table>
        <hr class="border">
        
        <form method="post" action="LogonProfesorIngreso" class="formulario">
            <div class="form-group">
            <i class="icono izquierda fa fa-user"></i><input type="text" name="usuario" class="usuario" 
            placeholder="Usuario">
            </div>

            <div class="form-group">
            <i class="icono izquierda fa fa-lock"></i><input type="password" name="password" class="password" placeholder="Contraseña">
            </div>
            <div class="form-group">
                <input id="btn-submit" type="submit" value="Ingresar"/>
            </div>
        </form>    
    </body>
</html>
