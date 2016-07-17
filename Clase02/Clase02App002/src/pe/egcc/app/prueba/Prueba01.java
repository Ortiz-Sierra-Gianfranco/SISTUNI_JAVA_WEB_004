package pe.egcc.app.prueba;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Prueba01 {

  public static void main(String[] args) {
    BigDecimal num = new BigDecimal(23.4567);
    num.setScale(2,RoundingMode.HALF_UP);
    System.out.println("num = " + num.doubleValue());
  }
}
