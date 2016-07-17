package pe.egcc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.dto.ItemDto;
import pe.egcc.service.CarritoService;


@WebServlet({"/CarritoAgregar","/CarritoListado"})
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String path = request.getServletPath();
      if(path.equals("/CarritoAgregar")){
        carritoAgregar(request,response);
      } else if(path.equals("/CarritoListado")){
        carritoListado(request,response);
      }
      
    
    }

    private void carritoListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      CarritoService carrito = obtenerCarrito(request);
      request.setAttribute("carrito", carrito);
      // Forward
      RequestDispatcher rd = request.getRequestDispatcher("listado.jsp");
      rd.forward(request, response);
    }

    private void carritoAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // Datos
      ItemDto dto = new ItemDto();
      dto.setNombre(request.getParameter("nombre"));
      dto.setPrecio(Double.parseDouble(request.getParameter("precio")));
      dto.setCant(Integer.parseInt(request.getParameter("cant")));
      // Obtener Carrito
      CarritoService service = obtenerCarrito(request);
      service.agregarItem(dto);
      // Forward
      request.setAttribute("mensaje", "Proceso ok.");
      RequestDispatcher rd = request.getRequestDispatcher("agregar.jsp");
      rd.forward(request, response);
    }

    private CarritoService obtenerCarrito(HttpServletRequest request) {
      CarritoService carrito;
      HttpSession session = request.getSession();
      if(session.getAttribute("carrito") == null){
        carrito = new CarritoService();
        session.setAttribute("carrito", carrito);
      } else {
        carrito = (CarritoService) session.getAttribute("carrito");
      }
      return carrito;
    }

}
