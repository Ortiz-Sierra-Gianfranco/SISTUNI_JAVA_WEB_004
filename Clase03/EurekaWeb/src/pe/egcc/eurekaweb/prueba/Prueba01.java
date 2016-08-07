package pe.egcc.eurekaweb.prueba;

import pe.egcc.eurekaweb.service.LogonService;
import pe.egcc.eurekaweb.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba01 {

  public static void main(String[] args) {   
    LogonService service = new LogonService();
    Empleado bean = service.validar("cromero", "chicho");
    if(bean != null){
      System.out.println("Nombre: " + bean.getNombre());
    } else {
      System.err.println("No existe.");
    }
  }
  
}
