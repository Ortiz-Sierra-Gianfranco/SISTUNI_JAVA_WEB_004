
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Database.AccesoDB;
import entity.Proveedor;
import service.IcrudDao;

public class ProveedorDao implements IcrudDao<Proveedor>{
 //variables
    Connection cn = null;
    Statement stm = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    //------------------
    @Override
    public void create(Proveedor t) throws Exception {
    try {
            cn = AccesoDB.getConnection();
            //inicio de transaccion
            cn.setAutoCommit(false);
            String codigo = generarCodigo();//llama a metodo
            t.setIdproveedor(codigo);
            sql = "insert into proveedores(idproveedor,razonsocial,direccion,ruc,telefono)"
                    + "values(?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdproveedor());
            ps.setString(2, t.getRazonsocial());
            ps.setString(3, t.getDireccion());
            ps.setString(4, t.getRuc());
            ps.setString(5, t.getTelefono());
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
    public void update(Proveedor t) throws Exception {
        try {
            cn=AccesoDB.getConnection();
            cn.setAutoCommit(false);
            sql="update proveedores set razonsocial=?,direccion=?,ruc=?,telefono=?"
                    +"where idproveedor=?";
            ps=cn.prepareStatement(sql);
            ps.setString(1,t.getRazonsocial());
            ps.setString(2, t.getDireccion());
            ps.setString(3,t.getRuc());
            ps.setString(4,t.getTelefono());
            ps.setString(5,t.getIdproveedor());
            ps.executeUpdate();
            ps.close();
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (SQLException el) {
            
            }
            throw e;
        }finally{
            cn.close();
        }
    }

    @Override
    public void delete(Proveedor t) throws Exception {
    try {
            cn = AccesoDB.getConnection();
            //inicio de transaccion
            cn.setAutoCommit(false);
            sql = "delete from proveedores where idproveedor=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdproveedor());
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
    public Proveedor find(Object t) throws Exception {
     Proveedor prov = null;
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from proveedores where idproveedor=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, (String) t);
            rs = ps.executeQuery();
            //cargar los productos de rs a la coleccion lista
            if (rs.next()) {
                prov = new Proveedor();
                //asignar valores al objeto pr
                prov.setIdproveedor(rs.getString(1));
                prov.setRazonsocial(rs.getString(2));
                prov.setDireccion(rs.getString(3));
                prov.setRuc(rs.getString(4));
                prov.setTelefono(rs.getString(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return prov;
    }

    @Override
    public List<Proveedor> readAll() throws Exception {
          List<Proveedor> lista = new ArrayList<Proveedor>();
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from proveedores order by razonsocial";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            //cargar los clientes de rs a la coleccion lista
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                //asignar valores al objeto cli
                prov.setIdproveedor(rs.getString(1));
                prov.setRazonsocial(rs.getString(2));
                prov.setDireccion(rs.getString(3));
                prov.setRuc(rs.getString(4));
                prov.setTelefono(rs.getString(5));
                lista.add(prov);
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
     public String findForName(String nombre) throws Exception {
       String id=null;
         try {
            cn = AccesoDB.getConnection();
            sql = "select idproveedor from proveedores where razonsocial='"+nombre+"'";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
             if(rs.next()){
             id=rs.getString(1);
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
    private String generarCodigo() throws SQLException {
        sql = "select valor from control where parametro='Proveedores'";
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.next();
        int cont = rs.getInt(1);
        rs.close();
        sql = "update control set valor=valor+1 where parametro ='Proveedores'";
        ps = cn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        String cod = "";
        if (cont < 10) {
            cod = "P000" + cont;
        } else {
            cod = "P00" + cont;
        }
        return cod;
    }
}
