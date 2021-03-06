<%-- 
    Document   : registroProfesor.jsp
    Created on : 11/08/2016, 01:01:09 PM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/SignIn.css">
        <title>COLEGIO</title>
    </head>
    <body>
        <div><jsp:include page="menuAdministrador.jsp"/></div>
        <div><jsp:include page="cabecera.jsp"/></div>
        <%
            if (request.getAttribute("info") != null) {
                out.print("<p>" + request.getAttribute("info").toString() + "</p>");
            }
        %>
        <c:if test="${requestScope.error != null}">
            <p>${requestScope.error}</p>
        </c:if>

        <h1 class="titulo-registro">Registro Profesor</h1>
        <hr class="border">

        <div class="contenedor-formulario">
            <div class="wrap">
                <form action="ProfesorRegistro" class="formulario" name="formulario_registro" method="post">
                    <div>
                        <div class="input-group">
                            <input type="text" name="usuario" value="${requestScope.usuario}" required>
                            <label class="label">Usuario:</label>
                        </div>
                        <div class="input-group">
                            <input type="text" name="nombres" value="${requestScope.nombres}" required>
                            <label class="label">Nombres:</label>
                        </div>
                        <div class="input-group">
                            <input type="text" name="dni" value="${requestScope.dni}" required>
                            <label class="label">DNI:</label>
                        </div>
                        <div class="input-group">
                            <input type="text" name="estudios" value="${requestScope.estudios}" required>
                            <label class="label">Estudios:</label>
                        </div>
                        <div class="input-group">
                            <input type="password" name="password">
                            <label class="label">Password:</label>
                        </div>
                        <div class="input-group">
                            <input type="password" name="confirm-password">
                            <label class="label">Repetir Password:</label>
                        </div>
                        <input type="submit" id="btn-submit" value="Registrar">
                    </div>
                </form>
            </div>
        </div>
        <script src="css/efectos.js"></script>
    </body>
</html>
