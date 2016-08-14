
package controller;

import java.util.List;
import dao.EmpleadoDao;
import entity.Empleado;

public class EmpleadoBll {
     //variables
    EmpleadoDao dao;

    //constructor
    public EmpleadoBll() {
        dao = new EmpleadoDao();
    }

    // metodos de negocio
    public List<Empleado> EmpleadoListar() throws Exception {
        return dao.readAll();
    }

    public void EmpleadoAdicionar(Empleado e) throws Exception {
        dao.create(e);
    }

    public void EmpleadoActualizar(Empleado e) throws Exception {
        dao.update(e);
    }

    public void EmpleadoEliminar(Empleado e) throws Exception {
        dao.delete(e);
    }
    
    public Empleado EmpleadoBuscar(Object e) throws Exception{
        return dao.find(e);
    }
 public String CodigodeEmpleado(String nombre) throws Exception{
        return dao.findForName(nombre);
    }
 public boolean EmpleadoValidar(String u,String p) throws Exception{
    return dao.valida(u, p);
    }
}
