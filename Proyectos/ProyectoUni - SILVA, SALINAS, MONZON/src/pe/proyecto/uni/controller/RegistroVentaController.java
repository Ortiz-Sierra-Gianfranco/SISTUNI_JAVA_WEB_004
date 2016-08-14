package pe.proyecto.uni.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.proyecto.uni.service.VentasService;

/**
 * Servlet implementation class RegistroVentaController
 */
@WebServlet("/RegistroVenta")
public class RegistroVentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroVentaController() {
    }

    @Override
   	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	  String path = request.getServletPath();
   	  if(path.equals("/RegistroVenta")){
   	    registrarVenta(request,response);
   	  }
   	}
    private void registrarVenta(HttpServletRequest request, 
  	    HttpServletResponse response) throws ServletException, IOException {
  	    String destino="RegistroVenta.jsp";
  	    boolean resultado;
  	    try {
  	      // Datos
  	      
  	      String idEmpleado = request.getParameter("hcodigo");
  	      String Cliente = request.getParameter("NomCliente");
  	      String xml = request.getParameter("hxml");
  	      // Proceso
  	      VentasService service = new VentasService();
  	      resultado = service.RegistrarVenta(idEmpleado, Cliente, xml);
  	      request.setAttribute("correcto", "Ejecutado");
  	    } catch (Exception e) {
  	      request.setAttribute("error", e.getMessage());
  	    }
  	    RequestDispatcher rd;
  	    rd = request.getRequestDispatcher(destino);
  	    rd.forward(request, response);
  	  }
    

}
