package pe.egcc.app.service;

import java.math.BigDecimal;

import pe.egcc.app.dto.VentaDto;

public class VentaService {
  
  public void procesar(VentaDto dto){
    // Variables
    double importe, impuesto, total;
    // Proceso
    total = dto.getPrecio() * dto.getCant();
    importe = total / 1.18;
    impuesto = total - importe;
    // Salida
    dto.setTotal(total);
    dto.setImporte(importe);
    dto.setImpuesto(impuesto);
  }

}
