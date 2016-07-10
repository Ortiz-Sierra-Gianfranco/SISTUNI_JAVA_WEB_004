package pe.egcc.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.service.MateService;


@WebServlet({"/Basico","/Factorial"})
public class MateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  

  @Override
  protected void service(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
   String path = request.getServletPath();
   if(path.equals("/Basico")){
     basico(request, response);
   } else if(path.equals("/Factorial")){
     factorial(request, response);
   }
    
  }
  
  
	private void factorial(HttpServletRequest request, 
	    HttpServletResponse response) throws IOException {
    int n = 0;
    long f = 0;
    String mensaje = null;
    try {
      // Datos
      n  = Integer.parseInt(request.getParameter("n"));
      // Proceso
      MateService service = new MateService();
      f = service.factorial(n);
    } catch (Exception e) {
      mensaje = e.getMessage();
    }
    // Salida
    PrintWriter out;
    out = response.getWriter();
    response.setContentType("text/html");
    out.print("<h1>MATEMATICA</h1>");
    if(mensaje == null){
      out.print("N: " + n + "<br/>");
      out.print("Factorial: " + f + "<br/>");
    } else {
    out.print("Error: " + mensaje + "<br/>");
    }

  }


  protected void basico(HttpServletRequest request, 
	    HttpServletResponse response) throws ServletException, IOException {
    String operacion = null;
    int rpta = 0, n1 = 0, n2 = 0, opera = 0;
    try {
      // Datos
      opera  = Integer.parseInt(request.getParameter("opera"));
      n1  = Integer.parseInt(request.getParameter("n1"));
      n2  = Integer.parseInt(request.getParameter("n2"));
      // Proceso
      MateService service = new MateService();
      if(opera == 1){
        operacion = "Suma";
        rpta = service.sumar(n1, n2);
      } else if(opera == 2) {
        operacion = "Producto";
        rpta = service.producto(n1, n2);
      } else {
        operacion = "No se";
        rpta = 0;
      }
    } catch (Exception e) {
      operacion = "Desconocida";
      rpta = 0;
    }
    // Salida
    PrintWriter out;
    out = response.getWriter();
    response.setContentType("text/html");
    out.print("<h1>MATEMATICA</h1>");
    out.print("N1: " + n1 + "<br/>");
    out.print("N2: " + n2 + "<br/>");
    out.print("Operación: " + operacion + "<br/>");
    out.print("Rpta: " + rpta + "<br/>");
	}
	
	
	
}