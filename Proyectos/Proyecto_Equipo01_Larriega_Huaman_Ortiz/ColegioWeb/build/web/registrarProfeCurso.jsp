<%-- 
    Document   : RegistrarProfeCurso
    Created on : Aug 11, 2016, 11:42:41 PM
    Author     : Gianfranco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="seguro.jsp"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/prueba.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/estilosTablas.css">

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


        <form method="post" action="AsigProfCurso2">


            <div class="container2">  

                <table id="tablaProf" border="1">
                    <thead>
                        <TR><p><h3>Haga click en un profesor para escogerlo</h3></p></TR>
                    <TR><TH colspan="4" style="text-align: center;font-size: 24px;background-color: #1566b7">Tabla Profesores</TH></TR>
                    <tr>
                        <th>
                            Nombres y Apellidos
                        </th>
                        <th>
                            DNI
                        </th>
                        <th>
                            Estudios
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="r" items="${listaProf}">
                            <tr>
                                <td class="prof" hidden="">${r.usuario}</td>
                                <td class="prof">${r.nombres}</td>
                                <td class="prof">${r.dni}</td>
                                <td class="prof">${r.estudios}</td>
                            </tr>
                        </c:forEach>
                    </tbody> 
                </table>
            </div>
            <center>
                <table class="margin_t">
                    <tr>
                        <th class="style_th">
                            Grado: 
                            <select name="GRADO">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>

                            </select>
                        </th>
                    </tr>
                    <tr>
                        <th class="style_th">
                            Curso: <select name="CURSO">
                                <c:forEach var="curso" items="${listaCurso}">
                                    <option>${curso.codigo}</option>
                                </c:forEach>
                            </select>
                        </th>
                    </tr>   
                    <tr>
                        <th class="style_th">
                            Profesor: <input type="text" name="usuarioProf" readonly id="profUSUARIO" hidden="" >
                            <input type="text" readonly=true id="PROFESOR">
                        </th>
                    </tr>
                    <tr>
                        <th class="style_th">
                            <input id="btn-submit" type="submit" value="REGISTRAR CURSO">
                        </th>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>
