/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.controller;

import colegioweb.domain.Administrador;
import colegioweb.domain.Alumnos;
import colegioweb.domain.Profesor;
import colegioweb.service.LogonService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LogonIngreso", "/LogonProfesorIngreso","/LogonAdministradorIngreso", "/LogonSalir"})
public class LogonController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/LogonIngreso")) {
            logonIngreso(request, response);
        } else if (path.equals("/LogonSalir")) {
            logonSalir(request, response);
        } else if (path.equals("/LogonProfesorIngreso")) {
            logonProfeIngreso(request, response);
        } else if (path.equals("/LogonAdministradorIngreso")) {
            logonAdmiIngreso(request, response);
        }

    }

    private void logonIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino = "";
        try {
            // Datos
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            // Proceso
            LogonService service = new LogonService();
            Alumnos bean = service.validar(usuario, password);
            // Guardar usuario en session
            HttpSession session = request.getSession();
            session.setAttribute("usuario", bean);
            //session.setMaxInactiveInterval(60);
            System.err.println("Time out:" + session.getMaxInactiveInterval());
            // Destino
            destino = "alumno.jsp";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destino = "loginAlumno.jsp";
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    private void logonSalir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    private void logonProfeIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino = "";
        try {
            // Datos
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            // Proceso
            LogonService service = new LogonService();
            Profesor bean = service.validarProfesor(usuario, password);
            // Guardar usuario en session
            HttpSession session = request.getSession();
            session.setAttribute("usuario", bean);
            //session.setMaxInactiveInterval(60);
            System.err.println("Time out:" + session.getMaxInactiveInterval());
            // Destino
            destino = "profesor.jsp";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destino = "loginProfesor.jsp";
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    private void logonAdmiIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String destino = "";
        try {
            // Datos
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            // Proceso
            LogonService service = new LogonService();
            Administrador bean = service.validarAdmi(usuario, password);
            // Guardar usuario en session
            HttpSession session = request.getSession();
            session.setAttribute("usuario", bean);
            //session.setMaxInactiveInterval(60);
            System.err.println("Time out:" + session.getMaxInactiveInterval());
            // Destino
            destino = "administrador.jsp";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destino = "loginAdministrador.jsp";
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

}
