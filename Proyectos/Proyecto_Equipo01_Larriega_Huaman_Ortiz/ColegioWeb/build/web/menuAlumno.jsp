<%-- 
    Document   : menuAlumno
    Created on : 10/08/2016, 01:03:54 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
        <link rel="stylesheet" type="text/css" href="css/estilosMenu.css">
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    </head>
    <body>
        <ul class="topnav" id="myTopnav">
            <li><a href="alumno.jsp"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
            <li><a href="matriculaAlumno.jsp"><i class="fa fa-graduation-cap" aria-hidden="true"></i> Matricular Alumno</a></li>
            <li><a href="#contact"><i class="fa fa-list-ul" aria-hidden="true"></i> Ver Notas</a></li>
            <li><a href="actualizaAlumno.jsp"><i class="fa fa-pencil" aria-hidden="true"></i> Actualizar Datos</a></li>
            <li><a href="configuracionAlumno.jsp"><i class="fa fa-cogs" aria-hidden="true"></i></i> Configuracion</a></li>
            <li><a href="LogonSalir"><i class="fa fa-sign-out" aria-hidden="true"></i> Salir</a></li>
            <li class="icon">
            <a href="javascript:void(0);" onclick="myFunction()">&#9776;</a>
            </li>
        </ul>
        <script>
            function myFunction() {
                 var x = document.getElementById("myTopnav");
                 if (x.className === "topnav") {
                    x.className += " responsive";
                } else {
                      x.className = "topnav";
                }
            }
        </script>
    </body>
</html>
