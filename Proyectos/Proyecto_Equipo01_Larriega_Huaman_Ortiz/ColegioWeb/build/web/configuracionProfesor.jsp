<%-- 
    Document   : configuracionProfesor
    Created on : 11/08/2016, 02:26:26 PM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp"/>
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
                
            <h1 class="titulo-matricula">Cambiar Contraseña</h1>
            
 <div class="wrap">
        <form action="ProfesorContraseña" method="post">
          
            <input class="form-control" type="password" name="password" required placeholder="Nuevo Password"/>
              
            <input class="form-control" type="password" name="confirm-password" required placeholder="Confirmar Password"/>
              
            <label>Usuario:</label><input class="form-control" type="text" name="usuario" value="${sessionScope.usuario.usuario}" readonly="readonly"/>
              
              <input id="btn-submit" type="submit" value="Cambiar Contraseña"/>
        </form>
 </div>
    </body>
</html>
