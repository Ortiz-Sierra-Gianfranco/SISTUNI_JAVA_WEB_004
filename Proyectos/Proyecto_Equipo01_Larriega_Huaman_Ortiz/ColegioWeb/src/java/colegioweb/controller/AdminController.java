/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.controller;

import colegioweb.domain.Profesor;
import colegioweb.service.AlumnoService;
import colegioweb.service.CursoProfesorService;
import colegioweb.service.CursoService;
import colegioweb.service.ProfesorService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet()
public class AdminController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession() == null) {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        String path = request.getServletPath();
        switch (path) {
            case "/AsigProfCurso":
                asignarProfe(request, response);
                break;
            case "/AsigProfCurso2":
                registrarDatosProfe(request, response);
                break;
            case "/ModifProfCurso":
                modifProfeCurso(request, response);
                break;
            case "/ModifProfCurso2":
                modifProfCursoDatos(request, response);
                break;
            case "/ElimProf":
                eliminarProfesor(request, response);
                break;
            case "/ElimProf2":
                eliminarProfesorDatos(request, response);
                break;
            case "/ElimAlum":
                EliminarAlumno(request, response);
                break;
            case "/ElimAlum2":
                EliminarAlumnoDatos(request, response);
                break;
            case "/RegistrarProfe":
                RegistrarProfe(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void asignarProfe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Object listaProf;
            ProfesorService profServ = new ProfesorService();
            listaProf = profServ.leerDatos();
            Object listaCurso;
            CursoService cursoServ = new CursoService();
            listaCurso = cursoServ.readAll();
            try {
                HttpSession session = request.getSession();
                if (listaCurso != null) {
                    request.setAttribute("listaCurso", listaCurso);
                } else {
                    throw new IllegalArgumentException("No hay profesores registrados");
                }
                if (listaProf != null) {
                    request.setAttribute("listaProf", listaProf);
                } else {
                    throw new IllegalArgumentException("No hay profesores registrados");
                }
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            } finally {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("registrarProfeCurso.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void eliminarProfesor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Object listaProf;
            ProfesorService profServ = new ProfesorService();
            listaProf = profServ.leerDatos();
            try {
                HttpSession session = request.getSession();
                if (listaProf != null) {
                    request.setAttribute("listaProf", listaProf);
                } else {
                    throw new IllegalArgumentException("No hay profesores registrados");
                }
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            } finally {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("eliminarProfesor.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void EliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Object listaAlum;
            AlumnoService alumServ = new AlumnoService();
            listaAlum = alumServ.leerDatos();
            try {
                HttpSession session = request.getSession();
                if (listaAlum != null) {
                    request.setAttribute("listaAlum", listaAlum);
                } else {
                    throw new IllegalArgumentException("No hay profesores registrados");
                }
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            } finally {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("eliminarAlumno.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registrarDatosProfe(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            CursoProfesorService cps = new CursoProfesorService();
            try {
                if (request.getParameter("usuarioProf") == null) {
                    throw new IllegalArgumentException("Ingrese un Profesor a Registrar");
                }
                cps.registrarDatos(request.getParameter("GRADO"), request.getParameter("usuarioProf"), request.getParameter("CURSO"));
            } catch (IllegalArgumentException | SQLException e) {
                request.setAttribute("error", e.getMessage());
            } finally {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/AsigProfCurso");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarProfesorDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfesorService prServ = new ProfesorService();
        try {
            prServ.delete(request.getParameter("PROFESOR"));

            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/ElimProf");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void EliminarAlumnoDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlumnoService alServ = new AlumnoService();
        try {
            String del = request.getParameter("ALUMNO");
            if (alServ.delete(del)) {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/ElimAlum");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modifProfeCurso(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Object listaProfCurso;
            CursoProfesorService csp = new CursoProfesorService();
            listaProfCurso = csp.readAll();
            Object listaProf;
            ProfesorService profServ = new ProfesorService();
            listaProf = profServ.leerDatos();
            try {
                HttpSession session = request.getSession();
                if (listaProf != null) {
                    request.setAttribute("listaProf", listaProf);
                } else {
                    throw new IllegalArgumentException("No hay profesores registrados");
                }
                if (listaProfCurso != null) {
                    request.setAttribute("listaProfCurso", listaProfCurso);
                } else {
                    throw new IllegalArgumentException("No hay profesores registrados");
                }
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            } finally {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("modificarProfeCurso.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modifProfCursoDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CursoProfesorService cps = new CursoProfesorService();
            try {
                if (cps.modificarProfesor(request.getParameter("codigoCurso"), request.getParameter("usuarioProf"))) {
                    request.setAttribute("info", "Se modifico correctamente");
                }
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            } finally {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/ModifProfCurso");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void RegistrarProfe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpta, usuario = "", nombres = "", dni = "", estudios = "";
        try {
            //Verifica password
            String password = request.getParameter("password");
            String confirmpass = request.getParameter("confirm-password");
            //Datos
            usuario = request.getParameter("usuario");
            nombres = request.getParameter("nombres");
            dni = request.getParameter("dni");
            estudios = request.getParameter("estudios");
            if (password.equals(confirmpass)) {
                //Proceso
                ProfesorService service = new ProfesorService();
                Profesor bean = new Profesor(usuario, nombres, dni, estudios, password);
                HttpSession session = request.getSession();
                //Insertar Alumno
                rpta = service.insertar(bean);
                if (rpta.equals("OK")) {
                    request.setAttribute("info", "Profesor registrado correctamente.");
                }
            } else {
                request.setAttribute("error", "Las constraseñas no coinciden");
                request.setAttribute("usuario", usuario);
                request.setAttribute("nombres", nombres);
                request.setAttribute("dni", dni);
                request.setAttribute("estudios", estudios);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("usuario", usuario);
            request.setAttribute("nombres", nombres);
            request.setAttribute("dni", dni);
            request.setAttribute("estudios", estudios);
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("admiRegistraProfesor.jsp");
        rd.forward(request, response);
    }
}
