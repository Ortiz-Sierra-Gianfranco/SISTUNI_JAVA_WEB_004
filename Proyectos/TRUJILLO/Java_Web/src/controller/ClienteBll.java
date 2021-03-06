/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import dao.ClienteDao;
import entity.Cliente;

/**
 *
 * @author Carlos YunZeg
 */
public class ClienteBll {
    ClienteDao dao;

    public ClienteBll() {
    dao=new ClienteDao();
    }
    
    public List<Cliente> ClienteListar()throws Exception{
        return dao.readAll();
    }
    public List<Cliente> ClienteListar(String nom) throws Exception {
        return dao.readAll(nom);
    }
    
      public void ClienteAdicionar(Cliente x) throws Exception {
        dao.create(x);
    }

    public void ClienteActualizar(Cliente x) throws Exception {
        dao.update(x);
    }

    public void ClienteEliminar(Cliente x) throws Exception {
        dao.delete(x);
    }

    public Cliente clienteBuscar(Object x) throws Exception {
        return dao.find(x);
    }
    
    public String CodigodeCliente(String nombre) throws Exception{
        return dao.findForName(nombre);
    }
    
    
}
