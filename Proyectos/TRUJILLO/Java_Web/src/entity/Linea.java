package entity;

public class Linea {

    //atributos
    private int idlinea;
    private String nombre;

    //constructor
    public Linea() {
    }

    public Linea(int idlinea, String nombre) {
        this.idlinea = idlinea;
        this.nombre = nombre;
    }

    //metodos get y set
    public int getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(int idlinea) {
        this.idlinea = idlinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
