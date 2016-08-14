<%-- 
    Document   : profesorVerCursos
    Created on : 13/08/2016, 08:10:48 PM
    Author     : Alumno
--%>
<%@page import="colegioweb.domain.Profesor"%>
<%@page import="colegioweb.service.ProfesorService"%>
<%@page import="colegioweb.db.AccesoDB"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
         <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/estilosAlumno.css">
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,300' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
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
                <h2>Lista de Cursos a cargo</h2>
            <table>

                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Nombre</th>
                </tr>
                <%
                    
                    Profesor bean=(Profesor)request.getSession().getAttribute("usuario");
                    Object usuario=bean.getUsuario();
                    Connection cn = null;
                    cn = AccesoDB.getConnection();
                    ProfesorService service = new ProfesorService();
                    int numeroDatos = service.cursosACargo(usuario).size();

                    for (int i = 0; i < numeroDatos; i++) {
                        out.println("<tr>");
                        out.println("<td>" + service.cursosACargo(usuario).get(i).getDni() + "</td>");
                        out.println("<td>" + service.cursosACargo(usuario).get(i).getEstudios()+ "</td>");

                        out.println("</tr>");
                    }
                %>
            </table>  
            </div>
    </body>
</html>
