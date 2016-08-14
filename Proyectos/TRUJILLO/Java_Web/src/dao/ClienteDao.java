/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Database.AccesoDB;
import entity.Cliente;
import service.IcrudDao;

/**
 *
 * @author Carlos YunZeg
 */
public class ClienteDao implements IcrudDao<Cliente> {
Connection cn = null;
    Statement stm = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    @Override
    public void create(Cliente t) throws Exception {
    try {
            cn = AccesoDB.getConnection();
            //inicio de transaccion
            cn.setAutoCommit(false);
            String codigo = generarCodigo();//llama a metodo
            t.setId_cliente(codigo);
            sql = "insert into clientes(idcliente,nombre,direccion,rucdni,telefono)"
                    + "values(?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getId_cliente());
            ps.setString(2, t.getNom_cliente());
            ps.setString(3, t.getDir_cliente());
            ps.setString(4, t.getRucdni_cliente());
            ps.setString(5, t.getTelefon_cliente());
            //Ejecuta el insert
            ps.executeUpdate();
            ps.close();
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (SQLException el) {

            }
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void update(Cliente t) throws Exception {
      try {
            cn = AccesoDB.getConnection();
            //inicio de transaccion
            cn.setAutoCommit(false);
            sql = "update clientes set nombre=?,direccion=?,rucdni=?,telefono=?"
                    + "where idcliente=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getNom_cliente());
            ps.setString(2, t.getDir_cliente());
            ps.setString(3, t.getRucdni_cliente());
            ps.setString(4, t.getTelefon_cliente());
            ps.setString(5, t.getId_cliente());
            //Ejecuta el insert
            ps.executeUpdate();
            ps.close();
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (SQLException el) {

            }
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void delete(Cliente t) throws Exception {
     try {
            cn = AccesoDB.getConnection();
            //inicio de transaccion
            cn.setAutoCommit(false);
            sql = "delete from clientes where idcliente=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getId_cliente());
            //Ejecuta el insert
            ps.executeUpdate();
            ps.close();
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (SQLException el) {

            }
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public Cliente find(Object t) throws Exception {
        Cliente cli = null;
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from clientes where idcliente=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, (String) t);
            rs = ps.executeQuery();
            //cargar los productos de rs a la coleccion lista
            if (rs.next()) {
                cli = new Cliente();
                //asignar valores al objeto pr
                cli.setId_cliente(rs.getString(1));
                cli.setNom_cliente(rs.getString(2));
                cli.setDir_cliente(rs.getString(3));
                cli.setRucdni_cliente(rs.getString(4));
                cli.setTelefon_cliente(rs.getString(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return cli;
    }

    @Override
    public List<Cliente> readAll() throws Exception {
    List<Cliente> lista = new ArrayList<Cliente>();
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from Clientes order by nombre";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            //cargar los productos de rs a la coleccion lista
            while (rs.next()) {
                Cliente cli = new Cliente();
                //asignar valores al objeto pr
                 cli.setId_cliente(rs.getString(1));
                cli.setNom_cliente(rs.getString(2));
                cli.setDir_cliente(rs.getString(3));
                cli.setRucdni_cliente(rs.getString(4));
                cli.setTelefon_cliente(rs.getString(5));
                lista.add(cli);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }
    public List<Cliente> readAll(String nombre) throws Exception {
        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from CLIENTES where NOMBRE like ?";
            ps = cn.prepareStatement(sql);
            //preparar el valor a pasar al parametro
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            //cargar los productos de rs a la coleccion lista
            while (rs.next()) {
                Cliente cli = new Cliente();
                //asignar valores al objeto pr
                cli.setId_cliente(rs.getString(1));
                cli.setNom_cliente(rs.getString(2));
                cli.setDir_cliente(rs.getString(3));
                cli.setRucdni_cliente(rs.getString(4));
                cli.setTelefon_cliente(rs.getString(5));
                lista.add(cli);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }
    private String generarCodigo() throws SQLException {
        sql = "select valor from control where parametro='Clientes'";
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.next();
        int cont = rs.getInt(1);
        rs.close();
        sql = "update control set valor=valor+1 where parametro ='Clientes'";
        ps = cn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        String cod = "";
        if (cont < 10) {
            cod = "C000" + cont;
        } else {
            cod = "C00" + cont;
        }
        return cod;
    }
    
    public String findForName(String nombre) throws Exception {
        String id = null;
        try {
            cn = AccesoDB.getConnection();
            sql = "select idcliente from clientes  where nombre='" + nombre + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            //cargar los clientes de rs a la coleccion lista
            if (rs.next()) {
                id = rs.getString(1);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return id;
    }
    
}