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
import pe.egcc.eurekaweb.service.CuentaService;

@WebServlet(urlPatterns = {"/CuentaDeposito","/CuentaRetiro",
    "/CuentaTrans","/CuentaApertura"})
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/CuentaDeposito")){
		  cuentaDeposito(request,response);
		}
	}

  private void cuentaDeposito(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String cuenta = "";
    double importe = 0;
    try {
      // Datos Necesarios
      cuenta = request.getParameter("cuenta");
      importe = Double.parseDouble(request.getParameter("importe"));
      // El empleado
      HttpSession session = request.getSession();
      Empleado bean = (Empleado) session.getAttribute("usuario");
      // Proceso
      CuentaService service = new CuentaService();
      service.procDeposito(cuenta, importe, bean.getCodigo());
      request.setAttribute("info", "Proceso ejecutado correctamente.");      
    } catch (Exception e) {
      request.setAttribute("cuenta", cuenta);
      request.setAttribute("importe", importe);
      request.setAttribute("error", e.getMessage());
    }
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procDeposito.jsp");
    rd.forward(request, response);
  }

}
