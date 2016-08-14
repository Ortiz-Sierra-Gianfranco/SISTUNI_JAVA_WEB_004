package entity;

public class Cliente {
private String id_cliente;
private String nom_cliente;
private String dir_cliente;
private String rucdni_cliente;
private String telefon_cliente;

    public Cliente() {
    }

    public Cliente(String id_cliente, String nom_cliente, String dir_cliente, String rucdni_cliente, String telefon_cliente) {
        this.id_cliente = id_cliente;
        this.nom_cliente = nom_cliente;
        this.dir_cliente = dir_cliente;
        this.rucdni_cliente = rucdni_cliente;
        this.telefon_cliente = telefon_cliente;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getDir_cliente() {
        return dir_cliente;
    }

    public void setDir_cliente(String dir_cliente) {
        this.dir_cliente = dir_cliente;
    }

    public String getRucdni_cliente() {
        return rucdni_cliente;
    }

    public void setRucdni_cliente(String rucdni_cliente) {
        this.rucdni_cliente = rucdni_cliente;
    }

    public String getTelefon_cliente() {
        return telefon_cliente;
    }

    public void setTelefon_cliente(String telefon_cliente) {
        this.telefon_cliente = telefon_cliente;
    }
    
     // metodo toString
    @Override
    public String toString() {
        return nom_cliente;
    }

   
}
