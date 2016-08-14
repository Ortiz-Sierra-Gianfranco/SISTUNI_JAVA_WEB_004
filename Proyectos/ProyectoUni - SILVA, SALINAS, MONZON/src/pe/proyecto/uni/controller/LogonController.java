package pe.proyecto.uni.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.proyecto.uni.domain.Empleado;
import pe.proyecto.uni.service.LogonService;

/**
 * Servlet implementation class LogonController
 */
@WebServlet("/LogonIngreso")
public class LogonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogonController() {
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String path = request.getServletPath();
	  if(path.equals("/LogonIngreso")){
	    logonIngreso(request,response);
	  }
	}
    private void logonIngreso(HttpServletRequest request, 
    	      HttpServletResponse response) throws ServletException, IOException {
    	    String destino="";
    	    try {
    	      // Datos
    	      String usuario = request.getParameter("usuario");
    	      String clave = request.getParameter("password");
    	      // Proceso
    	      LogonService service = new LogonService();
    	      Empleado bean = service.validar(usuario, clave);
    	      // Guardar usuario en session
    	      HttpSession session = request.getSession();
    	      session.setAttribute("usuario", bean.getUsuario());
    	      session.setAttribute("codigo", bean.getCodigo());
    	      // Destino
    	      destino = "inicio.jsp";
    	    } catch (Exception e) {
    	      request.setAttribute("error", e.getMessage());
    	      destino = "login.jsp";
    	    }
    	    RequestDispatcher rd;
    	    rd = request.getRequestDispatcher(destino);
    	    rd.forward(request, response);
    	  }
}
