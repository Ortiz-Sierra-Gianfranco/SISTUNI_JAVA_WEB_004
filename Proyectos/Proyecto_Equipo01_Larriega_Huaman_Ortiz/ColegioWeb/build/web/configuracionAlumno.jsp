<%-- 
    Document   : configuracionAlumno
    Created on : 10/08/2016, 03:36:19 PM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/estilosAlumno.css">
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,300' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <title>COLEGIO</title>
    </head>
    <body>
          
        <div><jsp:include page="menuAlumno.jsp"/></div>
        
        <div><jsp:include page="cabecera.jsp"/></div>
        
        <%
            if (request.getAttribute("info") != null) {
                out.print("<p>" + request.getAttribute("info").toString() + "</p>");
            }
        %>
        <c:if test="${requestScope.error != null}">
            <p>${requestScope.error}</p>
        </c:if>
            
            <div class="container">    
                <hr class="border"></div>
                
            <h1 class="titulo-matricula">Cambiar Contraseña</h1>
        
     <div class="wrap">
        <form action="AlumnoContraseña" method="post">
                
            <input class="form-control" type="password" name="password" placeholder="Nuevo Password :" required/>
                        
            <input class="form-control" type="password" name="confirm-password" placeholder="Confirmar Password :" required/>    
                
            <label>Usuario:</label><input class="form-control" type="text" name="usuario" value="${sessionScope.usuario.usuario}" readonly="readonly"/> </td>
                
                <input id="btn-submit" type="submit" value="Cambiar Contraseña"/>                
        </form>
     </div>

    </body>
</html>
