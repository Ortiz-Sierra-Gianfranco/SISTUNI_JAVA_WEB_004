/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import dao.ProveedorDao;
import entity.Proveedor;

/**
 *
 * @author Carlos YunZeg
 */
public class ProveedorBll {
    ProveedorDao dao;

    public ProveedorBll() {
    dao= new ProveedorDao();
    }
    
    public void ProveedorAdicionar(Proveedor pro) throws Exception{
        dao.create(pro);
    }
    public void ProveedorActualizar(Proveedor pro) throws Exception{
        dao.update(pro);
    }
    public void ProveedorEliminar(Proveedor pro) throws Exception{
        dao.delete(pro);
    }
    public Proveedor ProveedorBuscar(Object pro) throws Exception{
        return dao.find(pro);
    }
    
    public List<Proveedor> ProveedorListar() throws Exception{
        return dao.readAll();
    }
    
    public String codigoProveedor(String nombre) throws Exception{
    return dao.findForName(nombre);
    }
    
    
}
