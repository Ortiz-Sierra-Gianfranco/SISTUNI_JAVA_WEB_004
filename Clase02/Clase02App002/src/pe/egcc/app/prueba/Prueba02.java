package pe.egcc.app.prueba;

import pe.egcc.app.dto.VentaDto;
import pe.egcc.app.service.VentaService;

public class Prueba02 {

  public static void main(String[] args) {
    // Datos
    VentaDto dto = new VentaDto();
    dto.setPrecio(568.75);
    dto.setCant(9);
    // Proceso
    VentaService service = new VentaService();
    service.procesar(dto);
    // Reporte
    System.out.println("Importe: " + dto.getImporte());
    System.out.println("Impuesto: " + dto.getImpuesto());
    System.out.println("Total: " + dto.getTotal());
  }
}
