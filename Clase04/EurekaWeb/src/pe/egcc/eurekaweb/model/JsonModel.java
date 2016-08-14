package pe.egcc.eurekaweb.model;

public class JsonModel {

  /**
   * Codigo de error, 1 ok y -1 hay error.
   */
  private int code;
  /**
   * El texto asociado con el codigo de error.
   */
  private String texto;

  public JsonModel() {
  }

  public JsonModel(int code, String texto) {
    super();
    this.code = code;
    this.texto = texto;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

}
