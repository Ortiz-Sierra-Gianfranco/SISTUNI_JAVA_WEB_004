package pe.proyecto.uni.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;

import pe.proyecto.uni.domain.Venta;
import pe.proyecto.uni.service.VentasService;

/**
 * Servlet implementation class ListarVentaController
 */
@WebServlet("/ListarVenta")
public class ListarVentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarVentaController() {
    }

    @Override
   	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	  String path = request.getServletPath();
   	  if(path.equals("/ListarVenta")){
   		ListarVenta(request,response);
   	  }
   	}
    private void ListarVenta(HttpServletRequest request, 
  	    HttpServletResponse response) throws ServletException, IOException {
  	    String destino="BuscarVenta.jsp";
  	    ArrayList<Venta> ListaVentas = new ArrayList<Venta>();
  	    
  	    try {
  	      // Datos
  	      HttpSession session = request.getSession();
  	      
  	      int NumVenta;
  	      if (request.getParameter("NumVenta") == "")
  	      {
  	    	NumVenta = 0;
  	      }
  	      else{
  	    	NumVenta = Integer.parseInt(request.getParameter("NumVenta"));
  	      }
  	      String Cliente = request.getParameter("NomCliente");
  	      // Proceso
  	      VentasService service = new VentasService();
  	      ListaVentas = service.ListarVenta(NumVenta, Cliente);
  	      //JSONArray ar=new JSONArray(ListaVentas);
  	      //String Resultjson= ar.toString();
  	      request.setAttribute("ListaVentas", ListaVentas);
  	    } catch (Exception e) {
  	      request.setAttribute("error", e.getMessage());
  	    }
  	    RequestDispatcher rd;
  	    rd = request.getRequestDispatcher(destino);
  	    rd.forward(request, response);
  	  }

}
