package pe.egcc.service;

import java.util.ArrayList;
import java.util.List;

import pe.egcc.dto.ItemDto;

public class CarritoService {

  private List<ItemDto> lista;
  
  public CarritoService() {
    lista = new ArrayList<>();
  }
  
  public void agregarItem(ItemDto dto){
    dto.setImporte(dto.getPrecio() * dto.getCant());
    lista.add(dto);
  }
  
  public List<ItemDto> getLista() {
    return lista;
  }
  
  public double getTotal(){
    double total = 0.0;
    for(ItemDto dto: lista){
      total += dto.getImporte();
    }
    return total;
  }
}
