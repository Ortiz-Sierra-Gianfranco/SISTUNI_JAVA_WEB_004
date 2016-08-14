<%-- 
    Document   : reportesCursos
    Created on : 13/08/2016, 02:33:36 AM
    Author     : USUARIO
--%>

<%@page import="colegioweb.service.CursoService"%>
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
            <h2>Lista de Cursos</h2>
            <table>

                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                </tr>
                <%
                    Connection cn = null;
                    cn = AccesoDB.getConnection();
                    CursoService service = new CursoService();
                    int numeroDatos = service.readAll().size();

                    for (int i = 0; i < numeroDatos; i++) {
                        out.println("<tr>");
                        out.println("<td>" + service.readAll().get(i).getCodigo() + "</td>");
                        out.println("<td>" + service.readAll().get(i).getNombre() + "</td>");

                        out.println("</tr>");
                    }
                %>
            </table>  
        </div>

    </body>
</html>
