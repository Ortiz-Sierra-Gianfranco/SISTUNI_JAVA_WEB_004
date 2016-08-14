/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.AccesoDB;
import entity.Detalle;
import entity.Venta;
import service.IventaDao;

/**
 *
 * @author Carlos YunZeg
 */
public class VentaDao implements IventaDao<Venta>{
 //variables
    Connection cn = null;
    PreparedStatement ps = null;
    CallableStatement cs, cs1, cs2 = null;
    ResultSet rs = null;
    String sql = "";
    @Override
    public void registraVentas(Venta o) throws Exception {
       int nro;
        try {
            cn = AccesoDB.getConnection();
            // activa la transaccion
            cn.setAutoCommit(false);
            nro = numeroFactura();
            o.setIdventa(nro);
            sql = "{call sp_Registra_Venta(?,?,?,?,?,?)}";
            cs = cn.prepareCall(sql);
            //preparar los valores a pasar al sp
            cs.setInt(1, o.getIdventa());
            cs.setString(2, o.getIdcliente());
            cs.setString(3, o.getIdempleado());
            cs.setString(4, o.getTipodoc());
            cs.setString(5, o.getNrodoc());
            cs.setDouble(6, o.getTotal());
            //ejecutar sp
            cs.executeUpdate();
            sql = "{call sp_Registra_Detalle(?,?,?,?,?)}";
            cs1 = cn.prepareCall(sql);
            sql = "{call sp_Actualiza_Stock(?,?)}";
            cs2 = cn.prepareCall(sql);
            for (Detalle d : o.getDetalle()) {
                //preparar lovalores para sp de detalle
                cs1.setInt(1, o.getIdventa());
                cs1.setString(2, d.getIdproducto());
                cs1.setDouble(3, d.getPrecio());
                cs1.setInt(4, d.getCantidad());
                cs1.setDouble(5, d.getTotal());
                cs1.executeUpdate();//ejecuta sp de detalle
                //preparar los valores para sp de producto
                cs2.setInt(2, d.getCantidad());
                cs2.setString(1, d.getIdproducto());               
                cs2.executeUpdate();//
            }
            cs.close();
            cs1.close();
            cs2.close();
            cn.commit();//confirma la transaccion
        } catch (Exception e) {
            try {
                cn.rollback();//deshace la transaccion
            } catch (SQLException e1) {
            }
            throw e;
        } finally {
            cn.close();
        }
    }

    private int numeroFactura() throws SQLException {
        sql = "select valor from control where parametro='Ventas'";
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.next();
        int cont = rs.getInt(1);
        rs.close();
        sql = "update control set valor=valor+1 where parametro='Ventas'";
        ps = cn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        return cont;
    }
    
}
