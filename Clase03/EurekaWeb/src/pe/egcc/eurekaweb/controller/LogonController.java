package pe.egcc.eurekaweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.eurekaweb.domain.Empleado;
import pe.egcc.eurekaweb.service.LogonService;


@WebServlet(urlPatterns = {"/LogonIngreso","/LogonSalir"})
public class LogonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String path = request.getServletPath();
	  if(path.equals("/LogonIngreso")){
	    logonIngreso(request,response);
	  } if(path.equals("/LogonSalir")){
	    logonSalir(request,response);
    }
	  
	}

  private void logonSalir(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    session.invalidate();
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  }

  private void logonIngreso(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    String destino="";
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      LogonService service = new LogonService();
      Empleado bean = service.validar(usuario, clave);
      // Guardar usuario en session
      HttpSession session = request.getSession();
      session.setAttribute("usuario", bean);
      //session.setMaxInactiveInterval(60);
      System.err.println("Time out:" + session.getMaxInactiveInterval() );
      // Destino
      destino = "main.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }
	
	

}
