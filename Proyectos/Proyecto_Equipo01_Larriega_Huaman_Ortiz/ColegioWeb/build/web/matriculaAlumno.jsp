<%-- 
    Document   : matriculaAlumno
    Created on : 11/08/2016, 04:54:16 PM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp"/>
<%@ page import="java.util.*" %>
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
            Date dNow = new Date();
            int anio = Integer.parseInt(String.valueOf(dNow.getYear()));
            anio=anio+1900;
        %>

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
                
        <h1 class="titulo-matricula">Matricular Alumno</h1>
                
<div class="wrap">
    <form action="AlumnoMatricular" method="post">
	<label>Usuario :</label><input type="text" class="form-control" name="usuario" 
               placeholder="Usuario :" value="${sessionScope.usuario.usuario}" readonly="readonly">
        
        <input type="text" class="form-control" name="codigo" 
               placeholder="Codigo Matricula :">
			
	<select class="select-style form-control" name="grado">
               <option value="select">Elige Año de Estudio..</option>
               <option value="1">1</option>
               <option value="2">2</option>
               <option value="3">3</option>
               <option value="3">4</option>
               <option value="3">5</option>
        </select>
        
        <input type="text" class="form-control" name="anio" value="<%=anio%>" 
               placeholder="Año :" readonly="readonly">

        <input type="submit" name="submit" id="btn-submit" value="Matricularse">
    </form>
</div>
            
    </body>
</html>
