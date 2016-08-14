/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.domain;

/**
 *
 * @author USUARIO
 */
public class Cursos {
    String codigo,nombre;

    public Cursos(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    public Cursos(){
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
