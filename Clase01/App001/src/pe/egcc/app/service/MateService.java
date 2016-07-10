package pe.egcc.app.service;

public class MateService {

  public int sumar(int n1, int n2) {
    return (n1 + n2);
  }

  public int producto(int n1, int n2) {
    return (n1 * n2);
  }

  public long factorial(int n) {
    long f = 1;
    while(n> 1){
      f *= n--;
    }
    return f;
  }

}
