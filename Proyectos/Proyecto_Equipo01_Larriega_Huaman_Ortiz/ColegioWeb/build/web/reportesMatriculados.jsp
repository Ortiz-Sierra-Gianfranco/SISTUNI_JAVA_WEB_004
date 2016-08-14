<%-- 
    Document   : reportesMatriculados
    Created on : 13/08/2016, 02:33:09 AM
    Author     : USUARIO
--%>

<%@page import="colegioweb.service.MatriculadosService"%>
<%@page import="colegioweb.service.AlumnoService"%>
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
            <h2>Lista de Matriculados</h2>
            <table>

                <tr>
                    <th>Codigo</th>
                    <th>Usuario</th>
                    <th>Nombres y Apellidos</th>
                    <th>Grado</th>
                    <th>Año</th>
                </tr>
                <%
                    Connection cn = null;
                    cn = AccesoDB.getConnection();
                    MatriculadosService service = new MatriculadosService();
                    int numeroDatos = service.leerDatos().size();

                    for (int i = 0; i < numeroDatos; i++) {
                        out.println("<tr>");
                        out.println("<td>" + service.leerDatos().get(i).getCodigo() + "</td>");
                        out.println("<td>" + service.leerDatos().get(i).getUsuario() + "</td>");
                        out.println("<td>" + service.leerDatos().get(i).getNombres()+service.leerDatos().get(i).getApellidos()+ "</td>");
                        out.println("<td>" + service.leerDatos().get(i).getGrado() + "</td>");
                        out.println("<td>" + service.leerDatos().get(i).getAnio() + "</td>");
                        out.println("</tr>");
                    }
                %>
            </table>  
        </div>

    </body>
</html>
