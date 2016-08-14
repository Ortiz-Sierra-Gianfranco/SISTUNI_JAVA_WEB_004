<%-- 
    Document   : actualizaAlumno
    Created on : 10/08/2016, 01:21:55 PM
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
                
        <h1 class="titulo-matricula">Actualizar Datos</h1>
        
     <div class="wrap">
        <form method="post" action="AlumnoActualizar">
            
                
            <label>Usuario :</label><input class="form-control" type="text" name="usuario" placeholder="Usuario :" value="${sessionScope.usuario.usuario}" readonly="readonly"/>
                
            <label>Nombres :</label><input class="form-control" type="text" name="nombres" placeholder="Nombres :" value="${sessionScope.usuario.nombres}" required/>
  
            <label>Apellidos :</label><input class="form-control" type="text" name="apellidos" placeholder="Apellidos" value="${sessionScope.usuario.apellidos}" required/> 
                
            <label>Email :</label><input class="form-control" type="email" name="email" placeholder="Email :" value="${sessionScope.usuario.email}" required/> 
               
            <input id="btn-submit" type="submit" value="Actualizar"/>
            
            
        </form>
     </div>
    </body>
</html>
