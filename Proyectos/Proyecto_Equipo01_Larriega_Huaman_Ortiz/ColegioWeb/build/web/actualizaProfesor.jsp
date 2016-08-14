<%-- 
    Document   : actualizaProfesor
    Created on : 11/08/2016, 02:26:05 PM
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
         
        <div><jsp:include page="menuProfesor.jsp"/></div>
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
                
        <h1 class="titulo-matricula">Actualizar Datos</h1>
        
        <div class="wrap">
        
        <form method="post" action="ProfesorActualizar">
            
            <label>Usuario :</label><input class="form-control" type="text" name="usuario" value="${sessionScope.usuario.usuario}" readonly="readonly" placeholder="Usuario: "/>
                
            <label>Nombres :</label><input class="form-control" type="text" name="nombres" value="${sessionScope.usuario.nombres}" required placeholder="Nombres :"/>
                
            <label>Dni :</label><input class="form-control" type="text" name="dni" value="${sessionScope.usuario.dni}" required placeholder="DNI"/>
                
            <label>Estudios :</label><input class="form-control" type="text" name="estudios" value="${sessionScope.usuario.estudios}" required placeholder="Estudios: "/>
                
                <input id="btn-submit" type="submit" value="Actualizar"/>
                
        </form>
        </div>
    </body>
</html>
