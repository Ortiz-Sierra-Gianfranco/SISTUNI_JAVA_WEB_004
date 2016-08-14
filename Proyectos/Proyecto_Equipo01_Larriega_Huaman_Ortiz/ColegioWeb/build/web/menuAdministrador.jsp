<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
        <link rel="stylesheet" type="text/css" href="css/estilosAdministrador.css">
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    </head>
    <body>
        
        <ul id="myTopnav">
            <li><a href="administrador.jsp"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a></li>
            <li class="dropdown"><a href="#" class="dropbtn"><i class="fa fa-graduation-cap" aria-hidden="true"></i> Clases</a>
                <div class="dropdown-content">
                    <a href="AsigProfCurso">Asignar Profesores</a>
                    <a href="ModifProfCurso">Modificar</a>
                </div>
            </li>
            <li class="dropdown"><a href="#" class="dropbtn">Profesores</a>
                <div class="dropdown-content">
                    <a href="registroProfesor.jsp">Registrar</a>
                    <a href="ElimProf">Eliminar</a>
                </div>
            </li>
            <li class="dropdown"><a href="#" class="dropbtn">Alumnos</a>
                <div class="dropdown-content">
                    <a href="registroAlumno.jsp">Registrar</a>
                    <a href="ElimAlum">Eliminar</a>
                </div>
            </li>
            <li class="dropdown"><a href="#" class="dropbtn">Reportes</a>
                <div class="dropdown-content">
                    <a href="reportesAlumnos.jsp">Alumnos</a>
                    <a href="reportesMatriculados.jsp">Alumnos Matriculados</a>
                    <a href="reportesProfesores.jsp">Profesores</a>
                    <a href="reportesCursos.jsp">Cursos</a>
                </div>
            </li>
            <li><a href="LogonSalir"><i class="fa fa-sign-out" aria-hidden="true"></i> Salir</a></li>
        </ul>
    </body>
</html>