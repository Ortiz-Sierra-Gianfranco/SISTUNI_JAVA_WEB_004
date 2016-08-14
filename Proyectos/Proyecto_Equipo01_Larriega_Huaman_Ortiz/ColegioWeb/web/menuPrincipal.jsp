<%-- 
    Document   : menuPrincipal
    Created on : 11/08/2016, 11:42:02 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
        <link rel="stylesheet" type="text/css" href="css/estilosMenu.css">
       <!--<link rel="stylesheet" type="text/css" href="css/style.css">-->
       <link href='https://fonts.googleapis.com/css?family=Raleway:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    </head>
    <body>
        <ul class="topnav" id="myTopnav">
            <li><a href="index.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i> Login</a></li>
            <li><a href="loginAlumno.jsp"><i class="fa fa-graduation-cap" aria-hidden="true"></i> Alumnos</a></li>
            <li><a href="loginProfesor.jsp"><i class="fa fa-users" aria-hidden="true"></i> Profesores</a></li>
            <li><a href="loginAdministrador.jsp"><i class="fa fa-user" aria-hidden="true"></i> Administrador</a></li>
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
