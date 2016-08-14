<%-- 
    Document   : reportesProfesores
    Created on : 13/08/2016, 02:33:22 AM
    Author     : USUARIO
--%>

<%@page import="colegioweb.service.ProfesorService"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="colegioweb.db.AccesoDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
        <link rel="stylesheet" type="text/css" href="css/estilosTablas.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body> 
        <div><jsp:include page="menuAdministrador.jsp"/></div>
        <div><jsp:include page="cabecera.jsp"/></div>
        <div class="container">
            <h2>Lista de Profesores</h2>
            <table>

                <tr>
                    <th>Usuario</th>
                    <th>Nombres</th>
                    <th>DNI</th>
                    <th>Estudios</th>
                </tr>
                <%
                    Connection cn = null;
                    cn = AccesoDB.getConnection();
                    ProfesorService service = new ProfesorService();
                    int numeroDatos = service.leerDatos().size();

                    for (int i = 0; i < numeroDatos; i++) {
                        out.println("<tr>");
                        out.println("<td>" + service.leerDatos().get(i).getUsuario() + "</td>");
                        out.println("<td>" + service.leerDatos().get(i).getNombres() + "</td>");
                        out.println("<td>" + service.leerDatos().get(i).getDni() + "</td>");
                        out.println("<td>" + service.leerDatos().get(i).getEstudios() + "</td>");
                        out.println("</tr>");
                    }
                %>
            </table>  
        </div>

    </body>
</html>
