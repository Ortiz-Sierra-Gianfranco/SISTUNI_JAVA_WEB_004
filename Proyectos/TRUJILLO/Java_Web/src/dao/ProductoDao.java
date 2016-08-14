package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Database.AccesoDB;
import entity.Producto;
import service.IcrudDao;

public class ProductoDao implements IcrudDao<Producto> {

    //variables
    Connection cn = null;
    Statement stm = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    //------------------

    @Override
    public void create(Producto t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            //inicio de transaccion
            cn.setAutoCommit(false);
            String codigo = generarCodigo();//llama a metodo
            t.setIdproducto(codigo);
            sql = "insert into productos(idproducto,descripcion,idlinea,preciocompra,precioventa,stock)"
                    + "values(?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdproducto());
            ps.setString(2, t.getDescripcion());
            ps.setInt(3, t.getIdlinea());
            ps.setDouble(4, t.getPreciocompra());
            ps.setDouble(5, t.getPrecioventa());
            ps.setInt(6, t.getStock());
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
    public void update(Producto t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            //inicio de transaccion
            cn.setAutoCommit(false);
            sql = "update productos set descripcion=?,idlinea=?,preciocompra=?,precioventa=?,stock=?"
                    + "where idproducto=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getDescripcion());
            ps.setInt(2, t.getIdlinea());
            ps.setDouble(3, t.getPreciocompra());
            ps.setDouble(4, t.getPrecioventa());
            ps.setInt(5, t.getStock());
            ps.setString(6, t.getIdproducto());
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
    public void delete(Producto t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            //inicio de transaccion
            cn.setAutoCommit(false);
            sql = "delete from productos where idproducto=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdproducto());
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
    public Producto find(Object t) throws Exception {
        Producto pr = null;
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from productos where idproducto=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, (String) t);
            rs = ps.executeQuery();
            //cargar los productos de rs a la coleccion lista
            if (rs.next()) {
                pr = new Producto();
                //asignar valores al objeto pr
                pr.setIdproducto(rs.getString(1));
                pr.setDescripcion(rs.getString(2));
                pr.setIdlinea(rs.getInt(3));
                pr.setPreciocompra(rs.getDouble(4));
                pr.setPrecioventa(rs.getDouble(5));
                pr.setStock(rs.getInt(6));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return pr;

    }

    @Override
    public List<Producto> readAll() throws Exception {
        List<Producto> lista = new ArrayList<Producto>();
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from productos";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            //cargar los productos de rs a la coleccion lista
            while (rs.next()) {
                Producto pr = new Producto();
                //asignar valores al objeto pr
                pr.setIdproducto(rs.getString(1));
                pr.setDescripcion(rs.getString(2));
                pr.setIdlinea(rs.getInt(3));
//                 pr.setPreciocompra(rs.getDouble(4));
                pr.setPrecioventa(rs.getDouble(5));
                pr.setStock(rs.getInt(6));
                lista.add(pr);
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

    public List<Producto> readAll(String nombre) throws Exception {
        List<Producto> lista = new ArrayList<Producto>();
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from productos where descripcion like ?";
            ps = cn.prepareStatement(sql);
            //preparar el valor a pasar al parametro
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            //cargar los productos de rs a la coleccion lista
            while (rs.next()) {
                Producto pr = new Producto();
                //asignar valores al objeto pr
                pr.setIdproducto(rs.getString(1));
                pr.setDescripcion(rs.getString(2));
                pr.setIdlinea(rs.getInt(3));
//                 pr.setPreciocompra(rs.getDouble(4));
                pr.setPrecioventa(rs.getDouble(5));
                pr.setStock(rs.getInt(6));
                lista.add(pr);
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

    public List<Producto> readAll(int id) throws Exception {
        List<Producto> lista = new ArrayList<Producto>();
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from productos where idlinea=?";
            ps = cn.prepareStatement(sql);
            //preparar el valor a pasar al parametro
            ps.setInt(1, id);
            rs = ps.executeQuery();
            //cargar los productos de rs a la coleccion lista
            while (rs.next()) {
                Producto pr = new Producto();
                //asignar valores al objeto pr
                pr.setIdproducto(rs.getString(1));
                pr.setDescripcion(rs.getString(2));
                pr.setIdlinea(rs.getInt(3));
//                 pr.setPreciocompra(rs.getDouble(4));
                pr.setPrecioventa(rs.getDouble(5));
                pr.setStock(rs.getInt(6));
                lista.add(pr);
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
        sql = "select valor from control where parametro='Productos'";
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.next();
        int cont = rs.getInt(1);
        rs.close();
        sql = "update control set valor=valor+1 where parametro ='Productos'";
        ps = cn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        String cod = "";
        if (cont < 10) {
            cod = "A000" + cont;
        } else {
            cod = "A00" + cont;
        }
        return cod;
    }
    
    public Producto find(String t) throws Exception {
        Producto pr = null;
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from productos where descripcion=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t);
            rs = ps.executeQuery();
            //cargar los productos de rs a la coleccion lista
            if (rs.next()) {
                pr = new Producto();
                //asignar valores al objeto pr
                pr.setIdproducto(rs.getString(1));
                pr.setDescripcion(rs.getString(2));
                pr.setIdlinea(rs.getInt(3));
                pr.setPreciocompra(rs.getDouble(4));
                pr.setPrecioventa(rs.getDouble(5));
                pr.setStock(rs.getInt(6));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return pr;
    }
}