package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Database.AccesoDB;
import entity.Empleado;
import service.IcrudDao;

public class EmpleadoDao implements IcrudDao<Empleado>{
Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    String sql = "";
    @Override
    public void create(Empleado t) throws Exception {
         try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String codigo = generaCodigo();
            cs = cn.prepareCall("{call sp_Empleado_Adicionar(?,?,?,?,?,?)}");
            cs.setString(1, codigo);
            cs.setString(2, t.getNombre());
            cs.setString(3, t.getApellidos());
            cs.setString(4, t.getEmail());
            cs.setString(5, t.getUsuario());
            cs.setString(6, t.getClave());
            cs.executeUpdate();
            cs.close();
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (SQLException e1) {
            }
            throw e;
        } finally {
            cn.close();
        }

    }

    @Override
    public void update(Empleado t) throws Exception {
    try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);        
            cs = cn.prepareCall("{call sp_Empleado_Actualizar(?,?,?,?,?,?)}");
            cs.setString(1, t.getIdempleado());
            cs.setString(2, t.getNombre());
            cs.setString(3, t.getApellidos());
            cs.setString(4, t.getEmail());
            cs.setString(5, t.getUsuario());
            cs.setString(6, t.getClave());
            cs.executeUpdate();
            cs.close();
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (SQLException e1) {
            }
            throw e;
        } finally {
            cn.close();
        } 
    }

    @Override
    public void delete(Empleado t) throws Exception {
    try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);         
            cs = cn.prepareCall("{call sp_Empleado_Eliminar(?)}");
            cs.setString(1, t.getIdempleado());           
            cs.executeUpdate();
            cs.close();
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (SQLException e1) {
            }
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public Empleado find(Object t) throws Exception {
     Empleado emp= null;
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from empleados where idempleado=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, (String) t);
            rs = ps.executeQuery();
            //cargar los productos de rs a la coleccion lista
            if (rs.next()) {
                emp = new Empleado();
                //asignar valores al objeto pr
                emp.setIdempleado(rs.getString(1));
                emp.setNombre(rs.getString(2));
                emp.setApellidos(rs.getString(3));
                emp.setEmail(rs.getString(4));
                emp.setUsuario(rs.getString(5));
                emp.setClave(rs.getString(6));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return emp;
    }

    @Override
    public List<Empleado> readAll() throws Exception {
    
    List<Empleado> lista = new ArrayList<Empleado>();
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from empleados order by idempleado";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            lista = cargaLista(rs);
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }
     private String generaCodigo() throws SQLException {
        sql = "select valor from control where parametro='Empleados'";
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.next();
        int cont = rs.getInt(1);
        rs.close();
        sql = "update control set valor=valor+1 where parametro='Empleados'";
        ps = cn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        String cod = "";
        if (cont < 10) {
            cod = "E000" + cont;
        } else {
            cod = "E00" + cont;
        }
        return cod;
    }

    private List<Empleado> cargaLista(ResultSet rs) throws SQLException {
        List<Empleado> aux = new ArrayList<Empleado>();
        while (rs.next()) {
            Empleado emp = new Empleado();
            emp.setIdempleado(rs.getString(1));
            emp.setNombre(rs.getString(2));
            emp.setApellidos(rs.getString(3));
            emp.setEmail(rs.getString(4));
            aux.add(emp);
        }
        rs.close();
        return aux;
    }
    
    public String findForName(String nombre) throws Exception {
        String id = null;
        try {
            cn = AccesoDB.getConnection();
            sql = "select idempleado from empleados  where apellidos='" + nombre + "'";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            //cargar los clientes de rs a la coleccion lista
            if (rs.next()) {
                id = rs.getString(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return id;
    }
       public boolean valida(String usu,String pass) throws Exception {
        boolean sw;
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from empleados where usuario=? and clave=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, usu);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            sw=rs.next();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return sw;
    }
}
