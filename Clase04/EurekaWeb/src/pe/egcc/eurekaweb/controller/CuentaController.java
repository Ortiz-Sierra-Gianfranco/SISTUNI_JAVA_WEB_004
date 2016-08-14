package pe.egcc.eurekaweb.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import net.sf.jasperreports.engine.JasperRunManager;
import pe.egcc.eurekaweb.db.AccesoDB;
import pe.egcc.eurekaweb.domain.Empleado;
import pe.egcc.eurekaweb.model.JsonModel;
import pe.egcc.eurekaweb.service.CuentaService;

@WebServlet(urlPatterns = { "/CuentaDeposito", "/CuentaRetiro", "/CuentaTrans", "/CuentaApertura", "/CuentaTraerDatos",
    "/CuentaRepoMovimientos" })
public class CuentaController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = request.getServletPath();
    if (path.equals("/CuentaDeposito")) {
      cuentaDeposito(request, response);
    } else if (path.equals("/CuentaTraerDatos")) {
      cuentaTraerDatos(request, response);
    } else if (path.equals("/CuentaRepoMovimientos")) {
      cuentaRepoMovimientos(request, response);
    }
  }

  private void cuentaRepoMovimientos(HttpServletRequest request, HttpServletResponse response) {
    Connection cn = null;
    try {
      // Conexióm a la base de datos
      cn = AccesoDB.getConnection();
      // Parámetro
      String cuenta = request.getParameter("cuenta");
      Map<String, Object> parms = new HashMap<>();
      parms.put("CUENTA", cuenta);
      // El archivo
      String fileRepo = "/pe/egcc/eurekaweb/reports/repoMovimientos.jasper";
      InputStream isRepo = getClass().getResourceAsStream(fileRepo);
      byte[] bytes = JasperRunManager.runReportToPdf(isRepo, parms, cn);
      // Enviar el arreglo al browser
      response.setContentType("Application/pdf");
      response.setContentLength(bytes.length);
      ServletOutputStream out = response.getOutputStream();
      out.write(bytes, 0, bytes.length);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }
  }

  private void cuentaTraerDatos(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String cuenta = "";
    Map<String, Object> datos;
    JsonModel model = new JsonModel();
    try {
      // Datos Necesarios
      cuenta = request.getParameter("cuenta");
      // Datos
      CuentaService service = new CuentaService();
      datos = service.getDatosCuenta(cuenta);
      if (datos == null) {
        throw new Exception("Cuenta no existe,");
      }
      // Preparar el modelo
      Gson gson = new Gson();
      String texto = gson.toJson(datos);
      model.setTexto(texto);
      model.setCode(1);
    } catch (Exception e) {
      model.setCode(-1);
      model.setTexto(e.getMessage());
    }
    // Respuesta
    UtilController.generaRespuesta(response, model);
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
