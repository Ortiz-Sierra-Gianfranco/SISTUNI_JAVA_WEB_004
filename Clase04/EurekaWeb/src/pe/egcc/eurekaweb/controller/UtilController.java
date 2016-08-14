package pe.egcc.eurekaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.egcc.eurekaweb.model.JsonModel;

public final class UtilController {

  private UtilController() {
  }
  
  public static void generaRespuesta
      (HttpServletResponse response, JsonModel model) 
      throws IOException{
  
    // Crear JSON
    Gson gson = new Gson();
    String textoJson = gson.toJson(model);
    // Respuesta
    //response.setContentType("text/plain");
    response.setContentType("application/json");
    PrintWriter out = response.getWriter();
    out.println(textoJson);
    out.flush();
    out.close();
    
  }
}
